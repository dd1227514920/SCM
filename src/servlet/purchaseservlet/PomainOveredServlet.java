package servlet.purchaseservlet;

import dao.purchase.PomainDao;
import model.purchasemodel.ScmUser;

import java.io.IOException;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PomainOveredServlet",urlPatterns ={"/purchaseservlet/PomainOveredServlet"} )
public class PomainOveredServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String poId = request.getParameter("poId");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String time=sdf.format(new Date());
		String endUser = ((String)request.getSession().getAttribute("username"));
		PomainDao pmd = new PomainDao();
		try {
			pmd.overOnePomain(poId, time, endUser);
			request.getRequestDispatcher("../purchaseservlet/PomainOverServlet").forward(request, response);
			request.setAttribute("message", "了结成功");
		} catch (SQLException e) {
			request.setAttribute("message", "了结失败");
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
