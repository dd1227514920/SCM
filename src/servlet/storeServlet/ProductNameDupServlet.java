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
@WebServlet(name = "ProductNameDupServlet",urlPatterns = {"/storeServlet/ProductNameDupServlet"})
public class ProductNameDupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName=request.getParameter("productName");
        ProductDao pd=new ProductDao();
        boolean flag=pd.queryName(productName);
        PrintWriter out = response.getWriter();
        if(flag)
            out.print("产品名称重复");
        else
            out.print("√");
        out.flush();
        out.close();
    }
}
