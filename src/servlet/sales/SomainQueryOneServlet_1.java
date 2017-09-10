package servlet.sales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.SomainDao;
import model.sales.Somain;

@WebServlet(name = "SomainQueryOneServlet_1", urlPatterns = { "/sales/SomainQueryOneServlet_1" })
public class SomainQueryOneServlet_1 extends HttpServlet {// 根据soid查询somain记录

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到SomainQueryOneServlet_1");
		String soid_value = request.getParameter("soid_checked");
		SomainDao somainDao = new SomainDao();
		Somain somain = somainDao.queryOneSomain(soid_value);
		request.setAttribute("Somain_1", somain);
		request.getRequestDispatcher("/sales/SoitemQueryServlet_1").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
