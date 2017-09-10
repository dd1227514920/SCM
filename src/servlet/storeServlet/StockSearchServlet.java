package servlet.storeServlet;

import dao.storeDao.StockQueryDao;
import model.storeModel.Stock;

import javax.lang.model.element.NestingKind;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by leo on 2017/7/14.
 */
@WebServlet(name = "StockSearchServlet",urlPatterns = {"/storeServlet/StockSearchServlet"})
public class StockSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count=0;
        String id=request.getParameter("ID");
        String name=request.getParameter("Name");
        String min=request.getParameter("Min");
        String max=request.getParameter("Max");
        StockQueryDao sqd=new StockQueryDao();
        StringBuffer sql=new StringBuffer("select * from stock where");
        if(!"".equals(id)){
            sql.append(" ProductCode like '%"+id+"%'");
            count++;
        }
        if(!"".equals(name)){
            if(count==0){
                sql.append(" Name like '%"+name+"%'");
                count++;
            }else{
                sql.append(" and Name like '%"+name+"%'");
                count++;
            }
        }
        if(!"0".equals(min)){
            if(count==0){
                sql.append("  Num >="+min);
                count++;
            }else{
                sql.append(" and Num >="+min);
                count++;

            }
        }

        if(!"".equals(max)){
            if(count==0){
                sql.append(" Num <="+max);
            }else{
                sql.append(" and Num<="+max);

            }
        }
        ArrayList<Stock> al=sqd.search(sql.toString());
        System.out.println(sql.toString());
        request.setAttribute("SearchResult",al);
        request.getRequestDispatcher("/store/searchResult.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
