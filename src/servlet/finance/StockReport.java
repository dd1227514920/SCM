package servlet.finance;

import com.sun.prism.shader.DrawCircle_Color_AlphaTest_Loader;
import dao.finance.*;
import model.finance.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by JerryCheng on 2017.7.16.
 */
@WebServlet(name = "StockReport",urlPatterns = {"/financeservlet/StockReport"})
public class StockReport extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String begin=request.getParameter("begin");
        String end=request.getParameter("end");
        ArrayList<Instock> iss=new InStockDBOperator().Detailquery(begin,end);
        ArrayList<Outstock> oss=new OutStockDBOperator().Detailquery(begin,end);
        int numtotal=0;
        ArrayList<Stock> rss=new StockDBOperator().recovery(iss,oss);
        System.out.println(rss);
        for (Stock s:rss) {
            numtotal+=s.getNum();
        }
        System.out.println(numtotal);
        request.setAttribute("numtotal",numtotal);
        request.setAttribute("rss",rss);
        request.getRequestDispatcher("../finance/stockreport.jsp").forward(request,response);
    }
}
