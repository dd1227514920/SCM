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
@WebServlet(name = "InMoney",urlPatterns = {"/financeservlet/InMoney"})
public class InMoney extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<SoMain> sms=new SoMainDBOperator().query();
        for (SoMain sm:sms) {
            sm.setName(new CustomerDBOperator().queryname(sm.getCustomerCode()));
        }
        request.getSession().setAttribute("sms",sms);
        request.getRequestDispatcher("../finance/inmoney.jsp").forward(request,response);
      //  response.sendRedirect("../finance/inmoney.jsp");
     }
    }

