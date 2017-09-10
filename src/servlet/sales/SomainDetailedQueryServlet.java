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

@WebServlet(name = "SomainDetailedQueryServlet", urlPatterns = { "/sales/SomainDetailedQueryServlet" })
public class SomainDetailedQueryServlet extends HttpServlet {// 精确查询somain

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到SomainDetailedQueryServlet");
		String soid = request.getParameter("h1");
		String startTime = request.getParameter("h2");
		String endTime = request.getParameter("h6");
		String customerCode = request.getParameter("h3");
		String payType = request.getParameter("h4");
		String status = request.getParameter("h5");

		Somain somain = new Somain();
		if (soid != null && !soid.equals("")) {
			somain.setSoid(soid);
		} else {
			somain.setSoid("");
		}
		somain.setCreateTime("");
		if (customerCode != null && !customerCode.equals("")) {
			somain.setCustomerCode(customerCode);
		} else {
			somain.setCustomerCode("");
		}
		if (payType != null && !payType.equals("")) {
			somain.setPayType(payType);
		} else {
			somain.setPayType("");
		}
		if (status != null && !status.equals("")) {
			somain.setStatus(Integer.parseInt(status));
		} else {
			somain.setStatus(-1);
		}
		SomainDao somainDao = new SomainDao();
		ArrayList<Somain> somainMatched = somainDao.queryDetailedSomain(somain, startTime, endTime);
		request.setAttribute("somainMatched", somainMatched);
		request.getRequestDispatcher("/gztm/querySale.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
