package servlet.sales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.SomainDao;

@WebServlet(name = "SomainDeleteServlet", urlPatterns = { "/sales/SomainDeleteServlet" })
public class SomainDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到SomainDeleteServlet");
		String soid = request.getParameter("somain_checked");
		SomainDao somainDao = new SomainDao();
		somainDao.deleteSomain(soid);
		request.getRequestDispatcher("/sales/SoitemDeleteServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
