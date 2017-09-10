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
@WebServlet(name = "ShowSO2Servlet",urlPatterns = {"/storeServlet/ShowSO2Servlet"})
public class ShowSO2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //预付款到发货
        OutStockDao OutStockDao =new OutStockDao();
        ArrayList<SOMain> al= OutStockDao.querySOM(7,"预付款到发货");
        request.setAttribute("SOMain",al);
        request.getRequestDispatcher("/store/outstock.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
