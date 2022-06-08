package epam.project.bookshop.controller.filter;

import epam.project.bookshop.command.ParameterName;
import epam.project.bookshop.entity.type.Role;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = "/controller")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession httpSession = httpServletRequest.getSession();
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;


        String command = httpServletRequest.getParameter("command");

        Long roleId = (Long) httpSession.getAttribute(ParameterName.USER_ROLE_ID);

        if (roleId != null) {
            boolean permission = Role.findPermission(roleId, command);
            if (!permission){
                httpServletResponse.sendError(403);
            } else {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }

    }

    public void destroy() {
    }
//            if  (command.equals("login")){
//                Optional<Long> role = userDao.findUserRoleByUsernameAndPassword(username, password);
//
//                boolean permission = false;
//
//                if (role.isPresent()) {
//                    permission = Role.findPermission(role.get(), command);
//                }
//
//                if (!permission) {
//                    httpServletResponse.sendError(403);
//                } else if(role.get()==Role.ADMIN.ordinal()) {
//                    request.getRequestDispatcher(WebPageName.ADMIN_PAGE).forward(request, response);
//                }else {
//                    chain.doFilter(request, response);
//                }
//            } else {
//                chain.doFilter(request, response);
//            }
}
