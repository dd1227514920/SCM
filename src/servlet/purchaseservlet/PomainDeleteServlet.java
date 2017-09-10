package servlet.purchaseservlet;

import dao.purchase.PomainDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PomainDeleteServlet",urlPatterns ={"/purchaseservlet/PomainDeleteServlet"} )
public class PomainDeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String poId = request.getParameter("poId");
		PomainDao pd = new PomainDao();
		pd.deletePomain(poId,request);
		request.getRequestDispatcher("../purchaseservlet/PomainServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
