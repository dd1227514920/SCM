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

@WebServlet(name = "CustomerQueryServlet_2", urlPatterns = { "/sales/CustomerQueryServlet_2" })
public class CustomerQueryServlet_2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到CustomerQueryServlet_2");
		ArrayList<Customer> customerAll = new ArrayList<Customer>();
		CustomerDao customerDao = new CustomerDao();
		customerAll = customerDao.queryCustomerAll();
		request.setAttribute("customerAll", customerAll);
		request.getRequestDispatcher("/gztm/queryDetailedSale.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
