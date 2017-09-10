package servlet.storeServlet;

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
@WebServlet(name = "outStockSheetServlet",urlPatterns = {"/storeServlet/outStockSheetServlet"})
public class outStockSheetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dateMin=request.getParameter("DateMin");
        String dateMax=request.getParameter("DateMax");
        StockSheetDao sd=new StockSheetDao();
        List<StockRecord> al=sd.outStockSheet(dateMin,dateMax);
        Float money=sd.getMoney(al);
        request.setAttribute("outStockSheet",al);
        request.setAttribute("size",al.size());
        request.setAttribute("money",money);
        request.setAttribute("dateMin",dateMin);
        request.setAttribute("dateMax",dateMax);
        request.getRequestDispatcher("/store/outStockSheet.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
