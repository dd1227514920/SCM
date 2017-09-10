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

@WebServlet(name = "SoitemQueryServlet", urlPatterns = { "/sales/SoitemQueryServlet" })
public class SoitemQueryServlet extends HttpServlet {// 根据soid查询所有soitem记录

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到SoitemQueryServlet");
		String soid = request.getParameter("hidden_soid");
		SoitemDao soitemDao = new SoitemDao();
		ArrayList<Soitem> soitems = soitemDao.querySoitem(soid);
		request.setAttribute("soitemList", soitems);
		request.getRequestDispatcher("/sales/CustomerQueryServlet_4").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
