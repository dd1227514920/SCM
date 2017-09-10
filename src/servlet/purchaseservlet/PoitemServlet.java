package servlet.purchaseservlet;

import dao.purchase.PoitemDao;
import dao.purchase.ProductDao;
import model.purchasemodel.Poitem;
import model.purchasemodel.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PoitemServlet",urlPatterns ={"/purchaseservlet/PoitemServlet"} )
public class PoitemServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String poId = request.getParameter("poId");
		
		PoitemDao pid = new PoitemDao();
		ProductDao pdd = new ProductDao();
		try {
			List<Product> lpd = pdd.queryAllProduct();
			List<Poitem> lpi = pid.queryOnePoitems(poId);
			request.setAttribute("piList", lpi);
			request.setAttribute("prList", lpd);
			request.getRequestDispatcher("/purchase/poitem.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
