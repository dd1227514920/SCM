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
@WebServlet(name = "ShowSO3Servlet",urlPatterns = {"/storeServlet/ShowSO3Servlet"})
public class ShowSO3Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //货到付款
        OutStockDao OutStockDao =new OutStockDao();
        ArrayList<SOMain> al= OutStockDao.querySOM(1,"货到付款");
        request.setAttribute("SOMain",al);
        request.getRequestDispatcher("/store/outstock.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
