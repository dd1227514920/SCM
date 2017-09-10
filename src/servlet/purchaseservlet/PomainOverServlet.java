package servlet.purchaseservlet;

import dao.purchase.PomainDao;
import model.purchasemodel.Pomain;
import model.purchasemodel.ScmUser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PomainOverServlet",urlPatterns ={"/purchaseservlet/PomainOverServlet"} )
public class PomainOverServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PomainDao pmd = new PomainDao();
		try {
			List<Pomain> lpm = pmd.queryOverPomains(((String)request.getSession().getAttribute("username")));
			request.setAttribute("pList", lpm);
			request.getRequestDispatcher("/purchase/overPo.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
