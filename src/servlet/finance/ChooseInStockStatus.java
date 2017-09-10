package servlet.finance;
import dao.finance.PoMainDBOperator;
import dao.finance.VenderDBOPerator;
import model.finance.PoMain;

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
@WebServlet(name = "ChooseInStockStatus",urlPatterns = {"/financeservlet/ChooseInStockStatus"})
public class ChooseInStockStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String paytype=request.getParameter("paytype");
        System.out.println(paytype);
        ArrayList<PoMain> pms;

        if("预付款到发货".equals(paytype))
            pms = new PoMainDBOperator().query(paytype);
        else {
            int status = Integer.parseInt(request.getParameter("Status"));
            pms = new PoMainDBOperator().query(paytype, status);
        }
        for (PoMain pm:pms) {
            pm.setName(new VenderDBOPerator().queryname(pm.getVenderCode()));
        }
        request.getSession().setAttribute("pms",pms);
        response.sendRedirect("../finance/instock.jsp");
    }
}
