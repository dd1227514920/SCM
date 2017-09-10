package servlet.finance;

import dao.finance.ProductDBOperator;
import dao.finance.SoItemDBOperator;
import model.finance.SoItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by JerryCheng on 2017.7.17.
 */
@WebServlet(name = "QuerySoItem",urlPatterns = {"/financeservlet/QuerySoItem"})
public class QuerySoItem extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Soid=request.getParameter("Soid");
        System.out.println(Soid);
        ArrayList<SoItem> soitems=new SoItemDBOperator().query(Soid);
        for (SoItem soitem:soitems) {
            soitem.setName(new ProductDBOperator().queryname(soitem.getProductCode()));
            System.out.println(new ProductDBOperator().queryname(soitem.getProductCode()));
        }
        System.out.println(soitems.toString());
        request.setAttribute("sois",soitems);
        request.getRequestDispatcher("../finance/soitem.jsp").forward(request,response);
    }
}
