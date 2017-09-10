package servlet.storeServlet;

import dao.storeDao.StockQueryDao;
import model.storeModel.StockRecord;

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
@WebServlet(name = "StockDetailsServlet",urlPatterns = {"/storeServlet/StockDetailsServlet"})
public class StockDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productCode=request.getParameter("ProductCode");
        StockQueryDao sqd=new StockQueryDao();
        ArrayList<StockRecord> records=sqd.queryInRecord(productCode);
        records=sqd.queryOutRecord(productCode,records);
        request.setAttribute("records",records);
        request.getRequestDispatcher("/store/stockDetails.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
