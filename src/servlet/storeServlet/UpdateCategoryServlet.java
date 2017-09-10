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
@WebServlet(name = "UpdateCategoryServlet",urlPatterns = {"/storeServlet/UpdateCategoryServlet"})
public class UpdateCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryId=request.getParameter("categoryId1");
        String categoryName=request.getParameter("categoryName1");
        String categoryRemark=request.getParameter("categoryRemark1");
        System.out.println(categoryId);
        System.out.println(categoryName);
        System.out.println(categoryRemark);
        Category cate=new Category(Integer.parseInt(categoryId),categoryName,categoryRemark);
        CategoryDao cd=new CategoryDao();
        cd.updateCategory(cate);
        request.getRequestDispatcher("/storeServlet/CategoryServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
