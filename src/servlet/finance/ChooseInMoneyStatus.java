package servlet.finance;

import dao.finance.CustomerDBOperator;
import dao.finance.SoMainDBOperator;
import model.finance.SoMain;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by JerryCheng on 2017.7.13.
 */
@WebServlet(name = "ChooseInMoneyStatus",urlPatterns = {"/financeservlet/ChooseInMoneyStatus"})
public class ChooseInMoneyStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String paytype=request.getParameter("paytype");
        System.out.println(paytype);
        ArrayList<SoMain> sms;

        if("预付款到发货".equals(paytype))
            sms = new SoMainDBOperator().query(paytype);
        else {
            int status = Integer.parseInt(request.getParameter("Status"));
            sms = new SoMainDBOperator().query(paytype, status);
        }
        for (SoMain sm:sms) {
            sm.setName(new CustomerDBOperator().queryname(sm.getCustomerCode()));
        }
        request.getSession().setAttribute("sms",sms);
        response.sendRedirect("../finance/inmoney.jsp");
    }
}
