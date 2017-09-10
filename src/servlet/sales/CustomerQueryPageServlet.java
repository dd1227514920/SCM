package servlet.sales;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.CustomerDao;
import model.sales.Customer;
import model.sales.Page;

@WebServlet(name = "CustomerQueryPageServlet", urlPatterns = { "/sales/CustomerQueryPageServlet" })
public class CustomerQueryPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到CustomerQueryPageServlet");
		String pageDisplay = request.getParameter("page");// 要显示第几页
		int currentPage;
		int pageSize = 3;
		int CustomerRecordCount = 0;
		if (pageDisplay == null) {// 第一次查询，还没有page属性
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(pageDisplay);
		}
		CustomerDao customerDao = new CustomerDao();
		CustomerRecordCount = customerDao.queryCustomerAll().size();
		int totalPage = CustomerRecordCount % pageSize == 0 ? CustomerRecordCount / pageSize
				: CustomerRecordCount / pageSize + 1;
		Page page = new Page(currentPage, pageSize, totalPage);
		ArrayList<Customer> customerList;
		try {
			customerList = customerDao.queryCustomerAll(page);
			page.setData(customerList);
			request.setAttribute("customerPage", page);
			request.getRequestDispatcher("/gztm/customer.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
