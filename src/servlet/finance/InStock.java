package servlet.finance;

import dao.finance.PoMainDBOperator;
import dao.finance.ProductDBOperator;
import dao.finance.StockDBOperator;
import dao.finance.VenderDBOPerator;
import model.finance.PoMain;
import model.finance.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by JerryCheng on 2017.7.12.
 */
@WebServlet(name = "InStock",urlPatterns = {"/financeservlet/InStock"})
public class InStock extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<PoMain> pms=new PoMainDBOperator().query();
        for (PoMain pm:pms) {
            pm.setName(new VenderDBOPerator().queryname(pm.getVenderCode()));
        }
        request.getSession().setAttribute("pms",pms);
        request.getRequestDispatcher("../finance/instock.jsp").forward(request,response);
       // response.sendRedirect("../finance/instock.jsp");
    }
}
