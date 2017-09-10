package servlet.finance;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import dao.finance.PoMainDBOperator;
import dao.finance.SoMainDBOperator;
import model.finance.InOut;
import model.finance.PoMain;
import model.finance.SoMain;

/**
 * Created by JerryCheng on 2017.7.14.
 */
@WebServlet(name = "InOutServlet",urlPatterns = {"/financeservlet/InOutServlet"})
public class InOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String begin=request.getParameter("begin");
        String end=request.getParameter("end");
        String type=request.getParameter("type");
        String paytype=request.getParameter("paytype");
        String id=request.getParameter("id");
        InOut inout=new InOut(begin,end,type,paytype,id);
        ArrayList<SoMain> sms;
        ArrayList<PoMain> pms;
        if("in".equals(type)) {
            sms = new SoMainDBOperator().Detailquery(inout);
            request.setAttribute("sms",sms);
        }
        else if("out".equals(type)){
            pms = new PoMainDBOperator().Detailquery(inout);
            request.setAttribute("pms",pms);
        }
        request.setAttribute("inout",inout);
        request.getRequestDispatcher("../finance/inout.jsp").forward(request,response);
    }


}

