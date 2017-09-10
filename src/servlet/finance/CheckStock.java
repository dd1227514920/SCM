package servlet.finance;

import dao.finance.CheckStockDBOperator;
import dao.finance.ProductDBOperator;
import dao.finance.StockDBOperator;
import model.finance.Product;
import model.finance.Stock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by JerryCheng on 2017.7.11.
 */
@WebServlet(name = "CheckStock",urlPatterns = {"/financeservlet/CheckStock"})
public class CheckStock extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products=new ProductDBOperator().query();
        for (Product product:products) {
            product.setNum(new StockDBOperator().querynum(product.getProductcode()));
        }
        request.getSession().setAttribute("products",products);
        response.sendRedirect("../finance/stockcheck.jsp");
    }
}
