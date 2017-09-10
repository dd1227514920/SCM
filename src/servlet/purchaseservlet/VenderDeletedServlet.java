package servlet.purchaseservlet;

import dao.purchase.VenderDao;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VenderDeletedServlet",urlPatterns ={"/purchaseservlet/VVenderDeletedServlet"} )
public class VenderDeletedServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String vendercode=request.getParameter("vendercode");
		VenderDao vd = new VenderDao();
		try {
			vd.deletedVender(vendercode);
			request.setAttribute("message", "删除成功");
			request.getRequestDispatcher("/purchase/vender.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "删除失败");
			request.getRequestDispatcher("/purchase/vender.jsp").forward(request, response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
