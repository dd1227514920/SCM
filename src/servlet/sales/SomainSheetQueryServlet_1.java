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
import model.sales.Somain;

@WebServlet(name = "SomainSheetQueryServlet_1", urlPatterns = { "/sales/SomainSheetQueryServlet_1" })
public class SomainSheetQueryServlet_1 extends HttpServlet {// 查询所有的somain
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到SomainSheetQueryServlet_1");
		ArrayList<Somain> somainList = (ArrayList<Somain>) request.getAttribute("somainList");
		ArrayList<Soitem> soitemList = new ArrayList<Soitem>();
		SoitemDao soitemDao = new SoitemDao();
		for (Somain somain : somainList) {
			String soid = somain.getSoid();
			ArrayList<Soitem> soitems = soitemDao.querySoitem(soid);
			soitemList.addAll(soitems);
		}
		request.setAttribute("soitemList", soitemList);
		request.getRequestDispatcher("/gztm/sale_sheet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
