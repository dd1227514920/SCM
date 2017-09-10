package servlet.storeServlet;

import dao.storeDao.OutStockDao;
import model.storeModel.SOItem;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by leo on 2017/7/9.
 */
@WebServlet(name = "outStockServlet",urlPatterns = {"/storeServlet/outStockServlet"})
public class outStockServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user=request.getSession().getAttribute("username").toString();
//        String user="张三";
        String SOID=request.getParameter("sale");
        OutStockDao OutStockDao =new OutStockDao();
        ArrayList<SOItem> al= OutStockDao.querySOItem(SOID);
        //获得当前修改时的时间
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String date=format.format(new Date());

        //由al，user,date进行三个数据库的修改
        boolean flag=OutStockDao.sale(al,user,date);
        if(flag){
            request.setAttribute("stockinfo","出库成功");
        }else{
            request.setAttribute("stockinfo","出库失败");
        }

        request.getRequestDispatcher("/storeServlet/ShowSOMainServlet").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
