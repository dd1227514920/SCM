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

@WebServlet(name = "CustomerQueryServlet_4", urlPatterns = { "/sales/CustomerQueryServlet_4" })
public class CustomerQueryServlet_4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到CustomerQueryServlet_4");
		ArrayList<Customer> customerAll = new ArrayList<Customer>();
		CustomerDao customerDao = new CustomerDao();
		customerAll = customerDao.queryCustomerAll();
		request.setAttribute("customerAll", customerAll);
		request.getRequestDispatcher("/sales/ProductQueryServlet_1").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
