package epam.project.bookshop.command.impl;

import epam.project.bookshop.command.Command;
import epam.project.bookshop.command.ParameterName;
import epam.project.bookshop.command.WebPageName;
import epam.project.bookshop.entity.Genre;
import epam.project.bookshop.entity.User;
import epam.project.bookshop.exception.CommandException;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.GenreService;
import epam.project.bookshop.service.impl.GenreServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class FindAllGenresCommand implements Command {
   private static final Logger logger= LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {

        GenreService genreService= GenreServiceImpl.getInstance();

        try {
            List<Genre> genreList = genreService.findAll();
            request.setAttribute(ParameterName.GENRE_LIST, genreList);
        } catch (ServiceException e) {
            logger.error("Genres not found. " + e);
            throw new CommandException(e);
        }

        return WebPageName.GENRE_PAGE;
    }
}
