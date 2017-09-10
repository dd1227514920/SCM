package servlet.sales;

import dao.sales.TransactionDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteServlet_1", urlPatterns = { "/sales/DeleteServlet_1" })
public class DeleteServlet_1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到DeleteServlet_1");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String soid = request.getParameter("dsoitem_soid");
		String productCode = request.getParameter("dsoitem1");
		int num = Integer.parseInt(request.getParameter("dsoitem2"));
		float productTotal = Float.parseFloat(request.getParameter("productTotal_new"));
		TransactionDao transactionDao = new TransactionDao();
		transactionDao.deleteSoitem_Product(soid, productCode, num, productTotal);
		request.getRequestDispatcher("/gztm/querySale.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
