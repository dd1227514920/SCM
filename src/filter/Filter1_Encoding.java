package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by leo on 2017/7/7.
 */
@WebFilter(filterName = "Filter1_Encoding",urlPatterns = {"/*"},initParams = {@WebInitParam(name="encoding",value = "utf-8")})
public class Filter1_Encoding implements Filter {
    String encoding;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        encoding=config.getInitParameter("encoding");
    }


}
