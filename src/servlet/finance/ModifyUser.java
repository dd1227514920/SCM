package servlet.finance;

import dao.finance.UserDBOperator;
import model.finance.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by JerryCheng on 2017.7.10.
 */
@WebServlet(name = "ModifyUser",urlPatterns = {"/financeservlet/ModifyUser"})
public class ModifyUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String account=request.getParameter("username");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String createDate=request.getParameter("createDate");
        String status=request.getParameter("status");
        String limits[] = request.getParameterValues("limits");
        String limit="";
        for (String limitss:limits) {
            limit=limit+limitss+";";
        }
        limit=limit.substring(0,limit.length()-1);
        User user=new User(account,password,name,createDate,status,limit);

        try {
            request.setAttribute("updateflag",new UserDBOperator().update(user,account)?"success":"fail");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("../financeservlet/QueryUser").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
