package epam.project.bookshop.command.impl;

import epam.project.bookshop.command.Command;
import epam.project.bookshop.command.ParameterName;
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

public class UpdateUserCommand implements Command {
    Logger logger= LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {

        Map<String, String> userUpdate=new HashMap<>();
        userUpdate.put(FIRSTNAME, request.getParameter(FIRSTNAME));
        userUpdate.put(LASTNAME, request.getParameter(LASTNAME));
        userUpdate.put(USERNAME, request.getParameter(USERNAME));
        userUpdate.put(PASSWORD, request.getParameter(PASSWORD));
        userUpdate.put(EMAIL, request.getParameter(EMAIL));
        userUpdate.put(PHONE_NUMBER, request.getParameter(PHONE_NUMBER));

        userUpdate.entrySet().removeIf(entry -> entry.getValue() == null);

        for(Map.Entry<String, String> entry: userUpdate.entrySet()){
            if (entry.getValue()==null || entry.getValue().isEmpty()){
                logger.info("Remove " + entry.getKey() + " : " + entry.getValue());
                userUpdate.remove(entry.getKey());
            }
        }

        UserService userService= UserServiceImpl.getInstance();

        for (Map.Entry<String, String> entry : userUpdate.entrySet()) {
            logger.info(entry.getKey() + " : " + entry.getValue());
        }

        try {
            userService.update(userUpdate);

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
