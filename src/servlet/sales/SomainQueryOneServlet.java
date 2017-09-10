package servlet.sales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.SomainDao;
import model.sales.Somain;

@WebServlet(name = "SomainQueryOneServlet", urlPatterns = { "/sales/SomainQueryOneServlet" })
public class SomainQueryOneServlet extends HttpServlet {// 根据soid查询somain记录

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("跳转到SomainQueryOneServlet");
		String soid_value = request.getParameter("hidden_soid");
		SomainDao somainDao = new SomainDao();
		Somain somain = somainDao.queryOneSomain(soid_value);
		request.setAttribute("somain", somain);
		request.getRequestDispatcher("/sales/SoitemQueryServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
