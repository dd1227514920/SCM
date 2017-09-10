package servlet.purchaseservlet;

import dao.purchase.VenderDao;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VenderAddServlet",urlPatterns ={"/purchaseservlet/VenderAddServlet"} )
public class VenderAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String venderCode = request.getParameter("vendercode");
		VenderDao vd =new VenderDao();
		try {
			boolean flag = vd.isVender(venderCode);
			if(flag){
				request.setAttribute("message", "供应商编号已经存在");
				request.getRequestDispatcher("/purchase/vender.jsp").forward(request, response);
			}
			else{
				String vendercode = request.getParameter("vendercode");
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				String contactor = request.getParameter("contactor");
				String address = request.getParameter("address");
				String postcode = request.getParameter("postcode");
				String tel = request.getParameter("tel");
				String fax = request.getParameter("fax");
				String createdate = request.getParameter("createdate");
				vd.addVender(vendercode, name, password, contactor, address, postcode, tel, fax, createdate);
				request.setAttribute("message", "增加成功");
				request.getRequestDispatcher("/purchase/vender.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
