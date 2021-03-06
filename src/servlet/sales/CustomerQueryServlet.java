package servlet.sales;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.CustomerDao;
import model.sales.Customer;

@WebServlet(name = "CustomerQueryServlet", urlPatterns = { "/sales/CustomerQueryServlet" })
public class CustomerQueryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到CustomerQueryServlet");
		String customerCode = request.getParameter("i1");
		String name = request.getParameter("i2");
		String option = request.getParameter("i3");
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		CustomerDao customerDao = new CustomerDao();
		// if (customerCode.equals("") && name.equals("")) {
		// customerList = customerDao.queryCustomerAll();
		// } else {
		customerList = customerDao.queryCustomer(customerCode, name, option);
		// }
		request.setAttribute("customerList", customerList);
		request.getRequestDispatcher("/gztm/customer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
