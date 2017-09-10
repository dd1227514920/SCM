package servlet.sales;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.SomainDao;
import model.sales.Somain;

@WebServlet(name = "SomainSheetQueryServlet", urlPatterns = { "/sales/SomainSheetQueryServlet" })
public class SomainSheetQueryServlet extends HttpServlet {// 查询所有的somain
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到SomainSheetQueryServlet");
		String startTime = request.getParameter("start");
		String endTime = request.getParameter("end");
		SomainDao somainDao = new SomainDao();
		ArrayList<Somain> somainList = somainDao.querySomainByTime(startTime, endTime);
		int number = somainList.size();
		int totalPrice = 0;
		for (Somain somain : somainList) {
			totalPrice += somain.getProductTotal();
		}
		request.setAttribute("somainList", somainList);
		request.setAttribute("number", number);
		request.setAttribute("totalPrice", totalPrice);
		request.getRequestDispatcher("/sales/SomainSheetQueryServlet_1").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
