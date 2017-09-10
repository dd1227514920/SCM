package servlet.finance;

import dao.finance.PoMainDBOperator;
import dao.finance.SoMainDBOperator;
import model.finance.InOut;
import model.finance.PoMain;
import model.finance.SoMain;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by JerryCheng on 2017.7.14.
 */
@WebServlet(name = "MonthReport",urlPatterns = {"/financeservlet/MonthReport"})
public class MonthReport extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String begin=request.getParameter("begin");
        String end=request.getParameter("end");
        String type=request.getParameter("type");
        InOut inout=new InOut(begin,end,"","","");
        ArrayList<SoMain> sms = new SoMainDBOperator().Detailquery(inout);
        ArrayList<PoMain> pms = new PoMainDBOperator().Detailquery(inout);
        float intotal=0;
        float outtotal=0;
        for (SoMain sm:sms) {
            intotal+=sm.getSoTotal();
        }
        for (PoMain pm:pms) {
            outtotal+=pm.getPoTotal();
        }
        request.setAttribute("intotal",intotal);
        request.setAttribute("outtotal",outtotal);
        request.setAttribute("sms",sms);
        request.setAttribute("pms",pms);

        request.setAttribute("inout",inout);
        request.getRequestDispatcher("../finance/monthreport.jsp").forward(request,response);
    }
}
