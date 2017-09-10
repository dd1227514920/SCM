package servlet.storeServlet;

import dao.storeDao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by leo on 2017/7/11.
 */
@WebServlet(name = "DeleteProductServlet",urlPatterns = {"/storeServlet/DeleteProductServlet"})
public class DeleteProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code=request.getParameter("deleteProductCode");
        ProductDao pd=new ProductDao();
        boolean flag=pd.deleteProduct(code);
        if(flag){
            request.setAttribute("info","删除成功");
        }else{
            request.setAttribute("info","删除失败");
        }

        request.getRequestDispatcher("/storeServlet/PageSplitServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
