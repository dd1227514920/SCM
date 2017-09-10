package servlet.purchaseservlet;

import dao.purchase.VenderDao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VenderUpdateServlet",urlPatterns ={"/purchaseservlet/VenderUpdateServlet"} )
public class VenderUpdateServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		VenderDao vd =new VenderDao();
		String vendercode = request.getParameter("vendercode2");
		String name = request.getParameter("name2");
		String password = request.getParameter("password2");
		String contactor = request.getParameter("contactor2");
		String address = request.getParameter("address2");
		String postcode = request.getParameter("postcode2");
		String tel = request.getParameter("tel2");
		String fax = request.getParameter("fax2");
		String createdate = request.getParameter("createdate2");
		try {
			vd.updateVender(vendercode, name, password, contactor, address, postcode, tel, fax, createdate);
			request.setAttribute("message", "修改成功");
			request.getRequestDispatcher("/purchase/vender.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "修改失败");
			request.getRequestDispatcher("/purchase/vender.jsp").forward(request, response);
		}
		
	}

}
