package servlet.storeServlet;

import dao.storeDao.CategoryDao;
import model.storeModel.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by leo on 2017/7/10.
 */
@WebServlet(name = "AddCategoryServlet",urlPatterns = {"/storeServlet/AddCategoryServlet"})
public class AddCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryId=request.getParameter("categoryId");
        String categoryName=request.getParameter("categoryName");
        String categoryRemark=request.getParameter("categoryRemark");
        Category cate=new Category(Integer.parseInt(categoryId),categoryName,categoryRemark);
        CategoryDao cd=new CategoryDao();
        cd.addCategory(cate);
        request.setAttribute("info","添加成功");
        request.getRequestDispatcher("/storeServlet/CategoryServlet").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
