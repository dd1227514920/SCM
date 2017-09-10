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
@WebServlet(name = "ShowPO3Servlet",urlPatterns = {"/storeServlet/ShowPO3Servlet"})
public class ShowPO3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //货到付款
        InStockDao InStockDao =new InStockDao();
        ArrayList<POMain> al= InStockDao.queryPOM(1,"货到付款");
        request.setAttribute("POMain",al);
        request.getRequestDispatcher("/store/instock.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
