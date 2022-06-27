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
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {

        Map<String, String> userMap = new HashMap<>();
        userMap.put(FIRSTNAME, request.getParameter(FIRSTNAME));
        userMap.put(LASTNAME, request.getParameter(LASTNAME));
        userMap.put(USERNAME, request.getParameter(USERNAME));
        userMap.put(PASSWORD, request.getParameter(PASSWORD));
        userMap.put(EMAIL, request.getParameter(EMAIL));
        userMap.put(PHONE_NUMBER, request.getParameter(PHONE_NUMBER));
//        userMap.put(ID, request.getParameter("userId"));

        logger.info("User info: " +  request.getParameter("userId"));

        UserService userService = UserServiceImpl.getInstance();

        try {
            boolean update = userService.update(userMap);


            if (update) {
                return USERS_PAGE;
            } else {
                for (Map.Entry<String, String> entry : userMap.entrySet()) {
                    request.setAttribute(entry.getKey(), entry.getValue());
                }
                return USERS_UPDATE_PAGE;
            }

        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
