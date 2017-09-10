package servlet.sales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.SomainDao;

@WebServlet(name = "SomainQueryOneServlet_2", urlPatterns = { "/sales/SomainQueryOneServlet_2" })
public class SomainQueryOneServlet_2 extends HttpServlet {// 根据soid查询somain记录

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到SomainQueryOneServlet_2");
		String customerCode = request.getParameter("cc1");
		SomainDao somainDao = new SomainDao();
		boolean ifExit = somainDao.querySomainByCustomerCode(customerCode);
		request.setAttribute("ifHasSomainMatched", ifExit);
		request.getRequestDispatcher("/sales/CustomerDeleteServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
