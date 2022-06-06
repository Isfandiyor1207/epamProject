package epam.project.bookshop.command.impl;

import epam.project.bookshop.command.Command;
import epam.project.bookshop.command.ParameterName;
import epam.project.bookshop.command.WebPageName;
import epam.project.bookshop.exception.CommandException;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.UserService;
import epam.project.bookshop.service.impl.UserServiceImpl;
import epam.project.bookshop.validation.BaseValidation;
import epam.project.bookshop.validation.RegistrationValidation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import javax.xml.validation.Validator;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String username =  request.getParameter(ParameterName.USERNAME);
        String password = request.getParameter(ParameterName.PASSWORD);
        UserService userService = UserServiceImpl.getInstance();
        boolean authenticate;

        String page;
        HttpSession session = request.getSession();

        BaseValidation validation=new BaseValidation();

        if (validation.isEmpty(password) || validation.isEmpty(username)){
            request.setAttribute("login_error", "Login or Password is incorrect!");
            return WebPageName.INDEX_PAGE;
        }

        try {
            authenticate = userService.authenticate(username, password);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        if (authenticate){
            request.setAttribute("user", username);
            session.setAttribute("username", username);
            page = WebPageName.MAIN_PAGE;

        }else {
            request.setAttribute("login_error", "Login or Password is incorrect!");
//            request.setAttribute("status", "failed");
            page = WebPageName.INDEX_PAGE;
        }
        session.setAttribute("currentPage", page);
        return page;
    }

}
