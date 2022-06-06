package epam.project.bookshop.controller.filter;

import epam.project.bookshop.command.WebPageName;
import epam.project.bookshop.dao.UserDao;
import epam.project.bookshop.dao.impl.UserDaoImpl;
import epam.project.bookshop.entity.type.Role;
import epam.project.bookshop.exception.DaoException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebFilter(filterName = "AuthFilter", urlPatterns = "/controller")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession httpSession = httpServletRequest.getSession();
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        String command = httpServletRequest.getParameter("command");

        UserDao userDao = UserDaoImpl.getInstance();

        try {
            if  (command.equals("login")){
                Optional<Long> role = userDao.findUserRoleByUsernameAndPassword(username, password);

                boolean permission = false;

                if (role.isPresent()) {
                    permission = Role.findPermission(role.get(), command);
                }

                if (!permission) {
                    httpServletResponse.sendError(403);
                } else if(role.get()==Role.ADMIN.ordinal()) {
                    request.getRequestDispatcher(WebPageName.ADMIN_PAGE).forward(request, response);
                }else {
                    chain.doFilter(request, response);
                }
            } else {
                chain.doFilter(request, response);
            }

        } catch (DaoException e) {
            throw new ServletException(e);
        }

    }

    public void destroy() {
    }

}
