package servlet.storeServlet;

import dao.storeDao.InStockDao;
import model.storeModel.POItem;

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
@WebServlet(name = "GetStockDetailsServlet",urlPatterns = {"/storeServlet/GetStockDetailsServlet"})
public class GetStockDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String POID=request.getParameter("POID");
        InStockDao InStockDao =new InStockDao();
        ArrayList<POItem> al= InStockDao.queryPOItem(POID);
        request.setAttribute("POItem",al);
        request.getRequestDispatcher("/store/instockDetails.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
