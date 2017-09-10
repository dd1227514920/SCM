package servlet.storeServlet;

import dao.storeDao.StockQueryDao;
import model.storeModel.StockQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by leo on 2017/7/13.
 */
@WebServlet(name = "StockQueryServlet",urlPatterns = {"/storeServlet/StockQueryServlet"})
public class StockQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StockQueryDao sqd=new StockQueryDao();
        ArrayList<StockQuery> al=sqd.query();
        request.setAttribute("ProductStocks",al);
        request.getRequestDispatcher("/store/stockQuery.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
