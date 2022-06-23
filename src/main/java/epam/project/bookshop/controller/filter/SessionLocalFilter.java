package epam.project.bookshop.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(filterName = "SessionLocalFilter")
public class SessionLocalFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest servletRequest=(HttpServletRequest) request;

        if (servletRequest.getParameter("sessionLocale") != null){
            servletRequest.getSession().setAttribute("lang", servletRequest.getParameter("sessionLocale"));
        }

        chain.doFilter(request, response);
    }

    public void destroy() {
    }

}
