package servlet.finance;

import dao.finance.UserDBOperator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JerryCheng on 2017.7.19.
 */
@WebServlet(name = "Login",urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if(new UserDBOperator().queryexist(username,password)){
            request.getSession().setAttribute("username",username);
            response.sendRedirect("../index.jsp");
        }
        else {
            request.setAttribute("loginfail","用户名密码错误,请重新输入");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
