package epam.project.bookshop.command.impl;

import epam.project.bookshop.command.Command;
import epam.project.bookshop.command.ParameterName;
import epam.project.bookshop.command.WebPageName;
import epam.project.bookshop.entity.User;
import epam.project.bookshop.exception.CommandException;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.UserService;
import epam.project.bookshop.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class FindAllUsersCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        UserService userService = UserServiceImpl.getInstance();

        try {
            List<User> userList = userService.findAll();
            request.setAttribute(ParameterName.USER_LIST, userList);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return WebPageName.USERS_PAGE;
    }
}
