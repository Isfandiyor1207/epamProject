//package epam.project.bookshop.controller.filter;
//
//import epam.project.bookshop.entity.type.Role;
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.io.IOException;
//
//@WebFilter(filterName = "PreControllerFilter", urlPatterns ="/controller")
//public class PreControllerFilter implements Filter {
//    static Logger logger= LogManager.getLogger();
//    public void init(FilterConfig config) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest httpServletRequest= (HttpServletRequest) request;
//        HttpSession httpSession = httpServletRequest.getSession(false);
//
//        logger.info("Session in Controller : " + (httpSession != null? httpSession.getId():" session not created!"));
//
//        chain.doFilter(request, response);
//    }
//
//    public void destroy() {
//    }
//}
