//package epam.project.bookshop.controller.filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.io.IOException;
//
//@WebFilter(filterName = "PreIndexFilter", urlPatterns = "/index.jsp")
//public class PreIndexFilterImpl implements Filter {
//
//    static Logger logger= LogManager.getLogger();
//
//    public void init(FilterConfig config) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//
//        HttpServletRequest httpServletRequest= (HttpServletRequest) request;
//        HttpSession httpSession = httpServletRequest.getSession(false);
//
//        logger.info("Session in PreIndexFilter : " + (httpSession != null? httpSession.getId():" session not created!"));
//
//        chain.doFilter(request, response);
//    }
//
//    public void destroy() {
//    }
//}
