package servlet.sales;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.SomainDao;
import model.sales.Somain;

@WebServlet(name = "SomainQueryServlet", urlPatterns = { "/sales/SomainQueryServlet" })
public class SomainQueryServlet extends HttpServlet {// 查询所有的somain
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到SomainQueryServlet");
		SomainDao somainDao = new SomainDao();
		ArrayList<Somain> somainAll = somainDao.querySomain();
		request.setAttribute("somainList", somainAll);
		// response.sendRedirect("/scm/gztm/querySale.jsp");
		request.getRequestDispatcher("/gztm/querySale.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
