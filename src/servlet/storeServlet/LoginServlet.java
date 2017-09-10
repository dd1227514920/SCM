package servlet.storeServlet;

import dao.storeDao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by leo on 2017/7/19.
 */
@WebServlet(name = "LoginServlet",urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        UserDao ud=new UserDao();
        boolean flag=ud.login(username,password);
        if(flag){
            request.getSession().setAttribute("username",username);
            response.sendRedirect("../index.jsp");
        }else {
            request.setAttribute("loginFailed","您的账号有误，请重试！");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
