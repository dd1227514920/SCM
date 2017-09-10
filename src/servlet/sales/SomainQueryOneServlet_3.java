package servlet.sales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.SomainDao;

@WebServlet(name = "SomainQueryOneServlet_3", urlPatterns = { "/sales/SomainQueryOneServlet_3" })
public class SomainQueryOneServlet_3 extends HttpServlet {// 根据soid查询somain记录

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到SomainQueryOneServlet_3");
		boolean flag = false;
		String customerCodes = request.getParameter("cc2");
		String[] customerCodesArray = customerCodes.split("-");
		SomainDao somainDao = new SomainDao();
		for (int i = 0; i < customerCodesArray.length; i++) {
			boolean ifExit = somainDao.querySomainByCustomerCode(customerCodesArray[i]);
			if (ifExit == true) {
				request.setAttribute("hasCustomerMatched", true);
				flag = true;
				break;
			}
		}
		if (!flag) {
			request.setAttribute("hasCustomerMatched", false);
		}
		request.getRequestDispatcher("/sales/CustomersDeleteServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
