package epam.project.bookshop.command.impl;

import epam.project.bookshop.command.Command;
import epam.project.bookshop.command.WebPageName;
import epam.project.bookshop.exception.CommandException;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.GenreService;
import epam.project.bookshop.service.impl.GenreServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static epam.project.bookshop.command.ParameterName.GENRE_NAME;

public class UpdateGenreCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        GenreService genreService = GenreServiceImpl.getInstance();

        Map<String, String> genreMap = new HashMap<>();
        genreMap.put(GENRE_NAME, request.getParameter(GENRE_NAME));
        String page;
        try {
            if (genreService.update(genreMap)){
                page = WebPageName.GENRE_PAGE;
            }   else {

                for (Map.Entry<String, String> entry : genreMap.entrySet()) {
                    request.setAttribute(entry.getKey(), entry.getValue());
                }

                page = WebPageName.GENRE_UPDATE_PAGE;
            }

        } catch (ServiceException e) {
            logger.error("Genre is not updated. Error thrown from AddGenreCommand.");
            throw new CommandException(e);
        }
        return page;
    }
}
