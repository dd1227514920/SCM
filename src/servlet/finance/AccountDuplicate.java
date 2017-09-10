package servlet.finance;

import dao.finance.UserDBOperator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by JerryCheng on 2017.7.17.
 */
@WebServlet(name = "AccountDuplicate",urlPatterns ={"/financeservlet/AccountDuplicate"} )
public class AccountDuplicate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        PrintWriter out=response.getWriter();
        boolean flag=new UserDBOperator().isDuplicat(username);
        out.print(flag?"账号被注册过了":"√");
        out.flush();
        out.close();
    }
}
