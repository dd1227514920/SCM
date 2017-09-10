package servlet.sales;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.SoitemDao;
import model.sales.Soitem;

@WebServlet(name = "SoitemQueryServlet_2", urlPatterns = { "/sales/SoitemQueryServlet_2" })
public class SoitemQueryServlet_2 extends HttpServlet {// 根据soid查询所有soitem记录

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到SoitemQueryServlet_2");
		String soid = request.getParameter("soid_checked");
		SoitemDao soitemDao = new SoitemDao();
		ArrayList<Soitem> soitems = soitemDao.querySoitem(soid);
		request.setAttribute("soitemList_1", soitems);
		request.getRequestDispatcher("/gztm/sale_finished.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
