package servlet.sales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.CustomerDao;
import model.sales.Customer;

@WebServlet(name = "CustomerUpdateServlet", urlPatterns = { "/sales/CustomerUpdateServlet" })
public class CustomerUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到CustomerUpdateServlet");
		String customerCode = request.getParameter("customerCodeUpdate");
		String name = request.getParameter("nameUpdate");
		String password = request.getParameter("passwordUpdate");
		String contactor = request.getParameter("contactorUpdate");
		String address = request.getParameter("addressUpdate");
		String postcode = request.getParameter("postcodeUpdate");
		String createDate = request.getParameter("createDateUpdate");
		String tel = request.getParameter("telUpdate");
		String fax = request.getParameter("faxUpdate");
		Customer customer = new Customer(customerCode, name, password, contactor, address, postcode,
				tel, fax, createDate);
		CustomerDao customerDao = new CustomerDao();
		int result = customerDao.updateCustomer(customer);
		request.setAttribute("updateDone", result);
		request.removeAttribute("customer");
		request.getRequestDispatcher("/gztm/customer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
