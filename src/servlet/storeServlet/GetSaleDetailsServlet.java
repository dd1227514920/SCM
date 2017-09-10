package servlet.storeServlet;

import dao.storeDao.OutStockDao;
import model.storeModel.SOItem;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by leo on 2017/7/12.
 */
@WebServlet(name = "GetSaleDetailsServlet",urlPatterns = {"/storeServlet/GetSaleDetailsServlet"})
public class GetSaleDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String SOID=request.getParameter("SOID");
        OutStockDao OutStockDao =new OutStockDao();
        ArrayList<SOItem> al= OutStockDao.querySOItem(SOID);
        request.setAttribute("SOItem",al);
        request.getRequestDispatcher("/store/outstockDetails.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
