package servlet.sales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.CustomerDao;
import model.sales.Customer;

@WebServlet(name = "CustomerAddServlet", urlPatterns = { "/sales/CustomerAddServlet" })
public class CustomerAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到CustomerAddServlet");
		String customerCode = request.getParameter("customerCode");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String contactor = request.getParameter("contactor");
		String address = request.getParameter("address");
		String postcode = request.getParameter("postcode");
		String createDate = request.getParameter("createDate");
		String tel = request.getParameter("tel");
		String fax = request.getParameter("fax");
		Customer customer = new Customer(customerCode, name, password, contactor, address, postcode,
				tel, fax, createDate);
		CustomerDao customerDao = new CustomerDao();
		Customer customerExited = customerDao.queryOneCustomer(customerCode);
		if (customerExited != null) {
			request.setAttribute("customerDuplicate", "yes");
		} else {
			customerDao.addCustomer(customer);
			request.setAttribute("customerDuplicate", "no");
		}
		request.getRequestDispatcher("/sales/CustomerQueryPageServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
