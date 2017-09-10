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
@WebServlet(name = "PomainServlet",urlPatterns ={"/purchaseservlet/PomainServlet"} )
public class PomainServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PomainDao pd = new PomainDao();
		try {
			List<Pomain> lp = pd.queryAllPomains((String) request.getSession().getAttribute("username"));
			request.setAttribute("pList", lp);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		request.getRequestDispatcher("/purchase/pomain.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
