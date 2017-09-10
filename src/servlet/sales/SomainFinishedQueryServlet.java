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

@WebServlet(name = "SomainFinishedQueryServlet", urlPatterns = { "/sales/SomainFinishedQueryServlet" })
public class SomainFinishedQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到SomainFinishedQueryServlet");
		SomainDao somainDao = new SomainDao();
		String username = request.getSession().getAttribute("username").toString();
		ArrayList<Somain> somainFinished_HDFK = somainDao.querySomainFinished_HDFK(username);
		ArrayList<Somain> somainFinished_KDFH = somainDao.querySomainFinished_KDFH(username);
		ArrayList<Somain> somainFinished_YFKFH = somainDao.querySomainFinished_YFKFH(username);
		request.setAttribute("somainFinished_HDFK", somainFinished_HDFK);
		request.setAttribute("somainFinished_KDFH", somainFinished_KDFH);
		request.setAttribute("somainFinished_YFKFH", somainFinished_YFKFH);
		request.getRequestDispatcher("/gztm/sale_finished.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
