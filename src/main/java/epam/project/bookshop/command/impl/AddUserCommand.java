package epam.project.bookshop.command.impl;

import epam.project.bookshop.command.Command;
import epam.project.bookshop.command.ParameterName;
import epam.project.bookshop.command.WebPageName;
import epam.project.bookshop.entity.User;
import epam.project.bookshop.exception.CommandException;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static epam.project.bookshop.command.ParameterName.*;

public class AddUserCommand implements Command {
    public static final Logger logger= LogManager.getLogger();
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String repeatedPassword = request.getParameter(PSW_REPEAT);
        String password = request.getParameter(PASSWORD);

        UserServiceImpl userService = UserServiceImpl.getInstance();

        Map<String, String> addUser=new HashMap<>();
        addUser.put(FIRSTNAME, request.getParameter(FIRSTNAME));
        addUser.put(LASTNAME, request.getParameter(LASTNAME));
        addUser.put(USERNAME, request.getParameter(USERNAME));
        addUser.put(EMAIL, request.getParameter(EMAIL));
        addUser.put(PHONE_NUMBER, request.getParameter(PHONE_NUMBER));
        addUser.put(PASSWORD, request.getParameter(PASSWORD));

        String page;
        if (repeatedPassword.equals(password)) {

            try {
                if (userService.add(addUser)){
                    page = WebPageName.MAIN_PAGE; // fixme redirect is not working
                }else {
                    logger.info("user info is incorrect");

                    for (Map.Entry<String, String> entry : addUser.entrySet()) {
                        request.setAttribute(entry.getKey(), entry.getValue());
                    }

                    page = WebPageName.SIGNUP_PAGE;
                }
            } catch (ServiceException e) {
                throw new CommandException(e);
            }
        } else {
            request.setAttribute(PSW_REPEAT, "Password is not the same.");
            page = WebPageName.SIGNUP_PAGE;
        }
        return page;
    }
}
