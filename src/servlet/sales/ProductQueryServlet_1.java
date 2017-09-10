package servlet.sales;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.ProductDao;
import model.sales.Product;

@WebServlet(name = "ProductQueryServlet_1", urlPatterns = { "/sales/ProductQueryServlet_1" })
public class ProductQueryServlet_1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到ProductQueryServlet_1");
		ProductDao productDao = new ProductDao();
		ArrayList<Product> productList = productDao.queryProductAll();
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/gztm/sale_detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
