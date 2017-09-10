package servlet.finance;

import dao.finance.UserDBOperator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by JerryCheng on 2017.7.10.
 */
@WebServlet(name = "DeleteUser",urlPatterns = {"/financeservlet/DeleteUser"})
public class DeleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String account=request.getParameter("account");
        PrintWriter out=response.getWriter();
        try {
            if(new UserDBOperator().delete(account)){
                out.print("删除成功");
            }
            else{
                out.print("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();

    }
}
