package servlet.finance;
import dao.finance.UserDBOperator;
import model.finance.Page;
import model.finance.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by JerryCheng on 2017.7.10.
 */
@WebServlet(name = "QueryUser",urlPatterns = {"/financeservlet/QueryUser"})
public class QueryUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p = request.getParameter("page");//要显示的页数
        request.setAttribute("flag",request.getAttribute("flag"));
        int currentPage;
        if(p == null){
            currentPage = 1;
        }else{
            currentPage = Integer.parseInt(p);
        }
        Page page = new Page();
        page.setPageSize(4);
        page.setCurrentPage(currentPage);
        int count = new UserDBOperator().queryTotalCount();
        int totalPage = count%page.getPageSize()==0?count/page.getPageSize():count/page.getPageSize()+1;
        page.setTotalPage(totalPage);
        new UserDBOperator().queryData(page);
        request.setAttribute("userpage", page);
        request.getRequestDispatcher("../finance/queryuser.jsp").forward(request, response);

    }
}
