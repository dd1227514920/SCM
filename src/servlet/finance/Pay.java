package servlet.finance;

import dao.finance.PoMainDBOperator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by JerryCheng on 2017.7.12.
 */
@WebServlet(name = "Pay",urlPatterns = {"/financeservlet/Pay"})
public class Pay extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int status=Integer.parseInt(request.getParameter("status"));
       String payuser=(String)request.getSession().getAttribute("username");
       String poid=request.getParameter("poid");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String paytime=sdf.format(new Date());
        try {
            request.setAttribute("instockflag",new PoMainDBOperator().pay(poid,status,payuser,paytime)?"success":"fail");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("../financeservlet/InStock").forward(request,response);
    }
}
