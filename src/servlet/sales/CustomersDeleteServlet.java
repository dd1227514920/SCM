package servlet.sales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.CustomerDao;

@WebServlet(name = "CustomersDeleteServlet", urlPatterns = { "/sales/CustomersDeleteServlet" })
public class CustomersDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到CustomersDeleteServlet");
		String customerCodes = request.getParameter("cc2");
		String[] customerCodeArray = customerCodes.split("-");
		request.setAttribute("ifDone", "no");
		if (!(Boolean) request.getAttribute("hasCustomerMatched")) {
			CustomerDao customerDao = new CustomerDao();
			boolean flag = customerDao.deleteCustomers(customerCodeArray);
			if (flag) {
				request.setAttribute("ifDone", "yes");
			}
		}
		request.getRequestDispatcher("/sales/CustomerQueryServlet_3").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
