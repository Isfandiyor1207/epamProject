package epam.project.bookshop.command.impl;

import epam.project.bookshop.command.Command;
import epam.project.bookshop.command.ParameterName;
import epam.project.bookshop.command.WebPageName;
import epam.project.bookshop.exception.CommandException;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.UserService;
import epam.project.bookshop.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static epam.project.bookshop.validation.ValidationParameterName.*;

public class DeleteUserCommand implements Command {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String id = request.getParameter(ParameterName.DELETE_ID);
        UserService userService = UserServiceImpl.getInstance();

        logger.info("user id: " + id);

        try {
            if (!userService.deleteById(Long.valueOf(id))) {
                request.setAttribute(WORN_DELETED, ERROR_USER_NOT_DELETED_MSG);
            }
            return WebPageName.USERS_PAGE;
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
