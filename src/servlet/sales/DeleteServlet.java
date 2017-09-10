package servlet.sales;

import dao.sales.TransactionDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteServlet", urlPatterns = { "/sales/DeleteServlet" })
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到DeleteServlet");
		String soid = request.getParameter("somain_checked");
		TransactionDao transactionDao = new TransactionDao();
		transactionDao.deleteSomain_Soitem_Product(soid);
		request.getRequestDispatcher("/gztm/querySale.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
