package servlet.storeServlet;

import dao.storeDao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by leo on 2017/7/18.
 */
@WebServlet(name = "ProductCodeDupServlet",urlPatterns = {"/storeServlet/ProductCodeDupServlet"})
public class ProductCodeDupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productCode=request.getParameter("productCode");
        ProductDao pd=new ProductDao();
        boolean flag=pd.queryCode(productCode);
        PrintWriter out = response.getWriter();
        if(flag)
            out.print("产品编号重复");
        else
            out.print("√");
        out.flush();
        out.close();
    }
}
