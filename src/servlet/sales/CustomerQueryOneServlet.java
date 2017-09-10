package servlet.sales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.CustomerDao;
import model.sales.Customer;

@WebServlet(name = "CustomerQueryOneServlet", urlPatterns = { "/sales/CustomerQueryOneServlet" })
public class CustomerQueryOneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到CustomerQueryOneServlet");
		String customerCode = request.getParameter("cc");
		CustomerDao customerDao = new CustomerDao();
		Customer customer = customerDao.queryOneCustomer(customerCode);
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("/gztm/customer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
