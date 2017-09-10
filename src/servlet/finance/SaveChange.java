package servlet.finance;
import dao.finance.CheckStockDBOperator;
import dao.finance.StockDBOperator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import model.finance.CheckStock;
/**
 * Created by JerryCheng on 2017.7.12.
 */
@WebServlet(name = "SaveChange",urlPatterns = {"/financeservlet/SaveChange"})
public class SaveChange extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
    int num= Integer.parseInt(request.getParameter("num"));
    String type=(String) request.getParameter("type");
    String description=request.getParameter("Description");
    String createUser=(String)request.getSession().getAttribute("username");
    String productcode=(String)request.getSession().getAttribute("productcode");
    int originnum=new StockDBOperator().querynum(productcode);
    int realnum=0;
        if("0".equals(type)) {
            realnum = originnum + num;
        }
        if("1".equals(type)) {
            realnum = originnum - num;
        }
    String stocktime=new Date().toString();
    CheckStock cs=new CheckStock(productcode,originnum,realnum,stocktime,createUser,description,type);
        System.out.println(cs.toString());
    new CheckStockDBOperator().add(cs);
    new StockDBOperator().update(realnum,productcode);
    response.sendRedirect("../financeservlet/CheckStock");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


}
