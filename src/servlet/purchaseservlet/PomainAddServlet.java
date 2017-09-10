package servlet.purchaseservlet;

import dao.purchase.ProductDao;
import dao.purchase.VenderDao;
import model.purchasemodel.Product;
import model.purchasemodel.Vender;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PomainAddServlet",urlPatterns ={"/purchaseservlet/PomainAddServlet"} )
public class PomainAddServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		VenderDao vd = new VenderDao();
		ProductDao pdd = new ProductDao();
		try {
			List<Vender> lv = vd.queryAllVenders();
			List<Product> lpd = pdd.queryAllProduct();
			request.setAttribute("vList", lv);
			request.setAttribute("pdList", lpd);
			request.getRequestDispatcher("/purchase/addPo.jsp").forward(request, response);
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
