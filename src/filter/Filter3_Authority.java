package filter;

import dao.storeDao.UserDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by leo on 2017/7/18.
 */
@WebFilter(filterName = "Filter3_Authority",urlPatterns = {"/storeServlet/*","/store/*","/finance/*","/financeservlet/*","/sales/*","/gztm/*","/purchase/*","/purchaseservlet/*"})
public class Filter3_Authority implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;

        String username=request.getSession().getAttribute("username").toString();
        UserDao ud=new UserDao();
        String authority=ud.queryAuth(username);
        String[] auth=authority.split(";");
        System.out.println(auth.length);
        String path=request.getServletPath();
        boolean flag=false;
        for(String a:auth){
            if("财务".equals(a)&&path.startsWith("/financeservlet/")||"财务".equals(a)&&path.startsWith("/finance/")){
                flag=true;
            }else if("仓管".equals(a)&&path.startsWith("/storeServlet/")||"仓管".equals(a)&&path.startsWith("/store/")){
                flag=true;
            }else if("采购".equals(a)&&path.startsWith("/purchaseservlet/")||"采购".equals(a)&&path.startsWith("/purchase/")){
                flag=true;
            }else if("销售".equals(a)&&path.startsWith("/sales/")||"销售".equals(a)&&path.startsWith("/gztm/")){
                flag=true;
            }
        }
        if(flag){
            chain.doFilter(req,resp);
        }else{
            response.sendRedirect("../withoutAuthority.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
