package epam.project.bookshop.command.impl;

import epam.project.bookshop.command.Command;
import epam.project.bookshop.exception.CommandException;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.UserService;
import epam.project.bookshop.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static epam.project.bookshop.command.ParameterName.*;
import static epam.project.bookshop.command.WebPageName.*;

public class UpdateUserCommand implements Command {
    Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {

        Map<String, String> userUpdate = new HashMap<>();
        userUpdate.put(FIRSTNAME, request.getParameter(FIRSTNAME));
        userUpdate.put(LASTNAME, request.getParameter(LASTNAME));
        userUpdate.put(USERNAME, request.getParameter(USERNAME));
        userUpdate.put(PASSWORD, request.getParameter(PASSWORD));
        userUpdate.put(EMAIL, request.getParameter(EMAIL));
        userUpdate.put(PHONE_NUMBER, request.getParameter(PHONE_NUMBER));


        UserService userService = UserServiceImpl.getInstance();

        try {
            boolean update = userService.update(userUpdate);

            if (update) {
                return USERS_PAGE;
            }else {
                return USERS_UPDATE_PAGE;
            }


        } catch (ServiceException e) {
            try {
                throw new CommandException(e);
            } catch (CommandException ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }
}
