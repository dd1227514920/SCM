package servlet.storeServlet;

import dao.storeDao.CategoryDao;
import model.storeModel.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by leo on 2017/7/7.
 */
@WebServlet(name = "CategoryServlet",urlPatterns = {"/storeServlet/CategoryServlet"})
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDao cd=new CategoryDao();
        ArrayList<Category> al=cd.query();
        request.setAttribute("category",al);
//        request.setAttribute("info","null");
//        String info=request.getAttribute("info").toString();
//        request.setAttribute("info",info);
        request.getRequestDispatcher("/store/goodsClass.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
