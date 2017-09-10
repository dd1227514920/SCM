package servlet.storeServlet;

import dao.storeDao.CategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by leo on 2017/7/10.
 */
@WebServlet(name = "DeleteCategoryServlet",urlPatterns = {"/storeServlet/DeleteCategoryServlet"})
public class DeleteCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryId=request.getParameter("deleteCategoryId");
        CategoryDao cd=new CategoryDao();
        boolean flag=cd.deleteCategoryQuery(Integer.parseInt(categoryId));

        if(!flag){
            cd.deleteCategory(Integer.parseInt(categoryId));//有引用的时候删除失败尚未提示
            request.setAttribute("Delete","删除成功");
        }else{
            request.setAttribute("Delete","类中有产品，无法删除");
        }
        request.getRequestDispatcher("/storeServlet/CategoryServlet").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
