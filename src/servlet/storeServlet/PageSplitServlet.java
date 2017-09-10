package servlet.storeServlet;

import dao.storeDao.ProductDao;
import model.storeModel.Page;
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
@WebServlet(name = "PageSplitServlet",urlPatterns = {"/storeServlet/PageSplitServlet"})
public class PageSplitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage=request.getParameter("CurrentPage");
        if(currentPage==null){
            currentPage="1";
        }
        Page page=new Page();
        page.setCurrentPage(Integer.parseInt(currentPage));
        page.setPageSize(3);
        ProductDao pd=new ProductDao();
        pd.getTotalPage(page);
        pd.queryData(page);
        request.setAttribute("pageList", page);
        //得到所有的categoryID
        ArrayList<Integer> cl=pd.getCategorys();
        request.getSession().setAttribute("ProductsCategorys",cl);
        request.getRequestDispatcher("/store/goods.jsp").forward(request, response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
