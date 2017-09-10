package servlet.sales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.SomainDao;

@WebServlet(name = "SomainFinishServlet", urlPatterns = { "/sales/SomainFinishServlet" })
public class SomainFinishServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到SomainFinishServlet");
		String soid = request.getParameter("soid_finished");
		SomainDao somainDao = new SomainDao();
		boolean flag = somainDao.finishSomain(soid);
		if (flag) {
			request.setAttribute("finishDone", "yes");
		} else {
			request.setAttribute("finishDone", "no");
		}
		request.getRequestDispatcher("/sales/SomainFinishedQueryServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
