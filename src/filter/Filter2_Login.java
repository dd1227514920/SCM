package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by leo on 2017/7/18.
 */
@WebFilter(filterName = "Filter2_Login",urlPatterns = {"/storeServlet/*","/store/*","/finance/*","/financeservlet/*","/sales/*","/gztm/*","/purchase/*","/purchaseservlet/*"})
public class Filter2_Login implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        if(request.getSession().getAttribute("username")==null){
            response.sendRedirect("../storenotLogined.jsp");
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
