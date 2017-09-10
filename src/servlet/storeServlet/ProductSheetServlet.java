package servlet.storeServlet;

import dao.storeDao.ProductDao;
import dao.storeDao.ProductSheetDao;
import dao.storeDao.StockSheetDao;
import model.storeModel.StockRecord;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by leo on 2017/7/14.
 */
@WebServlet(name = "ProductSheetServlet",urlPatterns = {"/storeServlet/ProductSheetServlet"})
public class ProductSheetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dateMin=request.getParameter("DateMin");
        String dateMax=request.getParameter("DateMax");
        ProductSheetDao psd=new ProductSheetDao();
        int sum=psd.getSum()+psd.getRecord(dateMin,dateMax);
        request.setAttribute("Sum",sum);
        request.setAttribute("dateMin",dateMin);
        request.setAttribute("dateMax",dateMax);
        request.getRequestDispatcher("/store/productSheet.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
