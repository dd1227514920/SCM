package servlet.sales;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.CustomerDao;
import model.sales.Customer;

@WebServlet(name = "CustomerVerifyServlet", urlPatterns = { "/sales/CustomerVerifyServlet" })
public class CustomerVerifyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到CustomerVerifyServlet");

		// response.setContentType("text/html;charset=utf-8");

		String customerCode = request.getParameter("customerCode");
		PrintWriter out = response.getWriter();
		CustomerDao customerDao = new CustomerDao();
		Customer customer = customerDao.queryOneCustomer(customerCode);
		if (customer == null) {
			out.print("<span style='color:green'>可以添加该客户编号</span>");
		} else {
			out.print("<span style='color:red'>该客户编号已存在</span>");
		}
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
