//package epam.project.bookshop.controller.filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
//@WebFilter(filterName = "ForwardFilter", dispatcherTypes = {DispatcherType.FORWARD}, urlPatterns = "/pages/*")
//public class ForwardFilter implements Filter {
//
//    public void init(FilterConfig config) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//
//        HttpServletRequest httpServletRequest =(HttpServletRequest) request;
//        HttpSession session= httpServletRequest.getSession();
//        HttpServletResponse httpServletResponse= (HttpServletResponse) response;
//
//        request.setAttribute("filter_atr", "DispatcherType.FORWARD");
//
//        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/main.jsp");
//
//        chain.doFilter(request, response);
//    }
//
//    public void destroy() {
//    }
//
//}
