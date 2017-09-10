package servlet.finance;

import dao.finance.PoItemDBOperator;
import dao.finance.ProductDBOperator;
import dao.finance.SoItemDBOperator;
import model.finance.PoItem;
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
@WebServlet(name = "QueryPoItem",urlPatterns = {"/financeservlet/QueryPoItem"})
public class QueryPoItem extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Poid=request.getParameter("Poid");
        System.out.println(Poid);
        ArrayList<PoItem> poitems=new PoItemDBOperator().query(Poid);
        for (PoItem poitem:poitems) {
            poitem.setName(new ProductDBOperator().queryname(poitem.getProductCode()));
            System.out.println(new ProductDBOperator().queryname(poitem.getProductCode()));
        }
        System.out.println(poitems.toString());
        request.setAttribute("pois",poitems);
        request.getRequestDispatcher("../finance/poitem.jsp").forward(request,response);


    }
}
