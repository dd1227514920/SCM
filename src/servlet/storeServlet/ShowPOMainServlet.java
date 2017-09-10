package servlet.storeServlet;

import dao.storeDao.InStockDao;
import model.storeModel.POMain;

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
@WebServlet(name = "ShowPOMainServlet",urlPatterns = {"/storeServlet/ShowPOMainServlet"})
public class ShowPOMainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InStockDao InStockDao =new InStockDao();
        ArrayList<POMain> al= InStockDao.queryPOMain();
        request.setAttribute("POMain",al);
        request.getRequestDispatcher("/store/instockAll.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
