package servlet.storeServlet;

import dao.storeDao.ProductDao;
import model.storeModel.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by leo on 2017/7/11.
 */
@WebServlet(name = "UpdateProductServlet",urlPatterns = {"/storeServlet/UpdateProductServlet"})
public class UpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productCode=request.getParameter("productCode");
        String productName=request.getParameter("productName");
        String categoryId=request.getParameterValues("categoryId")[0];
        String productPrice=request.getParameter("productPrice");
        String unitName=request.getParameter("unitName");
        String createDate=request.getParameter("createDate");
        String remark=request.getParameter("remark");

        Product product=new Product();
        product.setProductCode(productCode);
        product.setName(productName);
        product.setCategoryID(Integer.parseInt(categoryId));
        product.setPrice(Float.parseFloat(productPrice));
        product.setUnitName(unitName);
        product.setCreateDate(createDate);
        product.setRemark(remark);

        ProductDao pd=new ProductDao();
        boolean flag=pd.updateProduct(product);
        if(flag){
            request.setAttribute("info","修改成功");
        }else{
            request.setAttribute("info","修改失败");
        }
        request.getRequestDispatcher("/storeServlet/PageSplitServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
