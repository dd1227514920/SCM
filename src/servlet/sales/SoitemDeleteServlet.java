package servlet.sales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.SoitemDao;

@WebServlet(name = "SoitemDeleteServlet", urlPatterns = { "/sales/SoitemDeleteServlet" })
public class SoitemDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到SoitemDeleteServlet");
		String soid = request.getParameter("somain_checked");
		SoitemDao soitemDao = new SoitemDao();
		soitemDao.deleteSoitem(soid);
		request.getRequestDispatcher("/gztm/querySale.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
