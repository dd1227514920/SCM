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
@WebServlet(name = "AddProductServlet",urlPatterns = {"/storeServlet/AddProductServlet"})
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao pd=new ProductDao();
        String productCode=request.getParameter("productCode");
        String productName=request.getParameter("productName");
        String[] categoryId=request.getParameterValues("categoryId");
        String Id=categoryId[0];
        String productPrice=request.getParameter("productPrice");
        String unitName=request.getParameter("unitName");
        String createDate=request.getParameter("createDate");
        String remark=request.getParameter("remark");

        //去数据库根据productCode查询是否已经存在.不重复就增加
        boolean flag=pd.queryCode(productCode);
        if(!flag){
            Product product=new Product();
            product.setProductCode(productCode);
            product.setName(productName);
            product.setUnitName(unitName);
            product.setCategoryID(Integer.parseInt(Id));
            product.setPrice(Float.parseFloat(productPrice));
            product.setCreateDate(createDate);
            product.setRemark(remark);
            pd.addProduct(product);
            request.setAttribute("info","添加成功");
        }else{
            request.setAttribute("info","添加失败");
        }

        request.getRequestDispatcher("/storeServlet/PageSplitServlet").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
