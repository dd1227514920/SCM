package servlet.storeServlet;

import dao.storeDao.OutStockDao;
import model.storeModel.SOMain;

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
@WebServlet(name = "ShowSOMainServlet",urlPatterns = {"/storeServlet/ShowSOMainServlet"})
public class ShowSOMainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OutStockDao inStockDao=new OutStockDao();
        ArrayList<SOMain> al=inStockDao.querySOMain();
        request.setAttribute("SOMain",al);
        request.getRequestDispatcher("/store/outstockAll.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
