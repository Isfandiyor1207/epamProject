package epam.project.bookshop.command.impl;

import epam.project.bookshop.command.Command;
import epam.project.bookshop.command.ParameterName;
import epam.project.bookshop.command.WebPageName;
import epam.project.bookshop.exception.CommandException;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.UserService;
import epam.project.bookshop.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class DeleteUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String id = request.getParameter(ParameterName.ID);
        UserService userService= UserServiceImpl.getInstance();

        try {
            if (userService.deleteById(Long.valueOf(id))){
                return WebPageName.INDEX_PAGE;
            }else {
                request.setAttribute("deleted_error", "User has not deleted!");
                String uri = request.getRequestURI();
                return uri.substring(uri.lastIndexOf("/") + 1);
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
