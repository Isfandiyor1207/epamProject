package epam.project.bookshop.command.impl;

import epam.project.bookshop.command.Command;
import epam.project.bookshop.command.WebPageName;
import epam.project.bookshop.exception.CommandException;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.GenreService;
import epam.project.bookshop.service.UserService;
import epam.project.bookshop.service.impl.GenreServiceImpl;
import epam.project.bookshop.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static epam.project.bookshop.command.ParameterName.DELETE_ID;
import static epam.project.bookshop.validation.ValidationParameterName.*;

public class DeleteGenreCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String id = request.getParameter(DELETE_ID);
        GenreService genreService = GenreServiceImpl.getInstance();

        logger.info("genre id: " + id);

        try {
            if (!genreService.deleteById(Long.valueOf(id))) {
                request.setAttribute(WORN_DELETED, ERROR_GENRE_NOT_DELETED_MSG);
            }
            return WebPageName.GENRE_PAGE;
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}
