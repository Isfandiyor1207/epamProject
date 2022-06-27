package epam.project.bookshop.command.impl;

import epam.project.bookshop.command.Command;
import epam.project.bookshop.command.ParameterName;
import epam.project.bookshop.command.WebPageName;
import epam.project.bookshop.entity.Author;
import epam.project.bookshop.entity.Genre;
import epam.project.bookshop.exception.CommandException;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.AuthorService;
import epam.project.bookshop.service.impl.AuthorServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class FindAllAuthorsCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {

        AuthorService authorService = AuthorServiceImpl.getInstance();

        try {
            List<Author> genreList = authorService.findAll();
            request.setAttribute(ParameterName.AUTHOR_LIST, genreList);
        } catch (ServiceException e) {
            logger.error("Authors not found. " + e);
            throw new CommandException(e);
        }

        return WebPageName.AUTHOR_PAGE;
    }
}
