package servlet.sales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.CustomerDao;

@WebServlet(name = "CustomerDeleteServlet", urlPatterns = { "/sales/CustomerDeleteServlet" })
public class CustomerDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到CustomerDeleteServlet");
		boolean deleteDone = false;
		String customerCode = request.getParameter("cc1");
		if (!(Boolean) request.getAttribute("ifHasSomainMatched")) {
			CustomerDao customerDao = new CustomerDao();
			customerDao.deleteCustomer(customerCode);
			deleteDone = true;
		}
		request.setAttribute("deleteDone", deleteDone);
		request.getRequestDispatcher("/sales/CustomerQueryPageServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
