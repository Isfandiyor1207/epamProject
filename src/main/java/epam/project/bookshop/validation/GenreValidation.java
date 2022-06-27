package epam.project.bookshop.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static epam.project.bookshop.command.ParameterName.GENRE_NAME;
import static epam.project.bookshop.validation.ValidationParameterName.ERROR_GENRE_NAME;
import static epam.project.bookshop.validation.ValidationParameterName.WORN_GENRE_NAME;

public class GenreValidation {
    private static final Logger logger = LogManager.getLogger();

    private static final String GENRE_NAME_REGEX = "[a-zA-Z]+";
    private static final GenreValidation instance = new GenreValidation();
    private static final BaseValidation baseValidation = BaseValidation.getInstance();

    private GenreValidation(){}

    public static GenreValidation getInstance() {
        return instance;
    }

    private boolean checkGenreNameToValidation(String name) {
        return !baseValidation.isEmpty(name) && name.matches(GENRE_NAME_REGEX);
    }

    public boolean genreValidation(Map<String, String> genreMap) {
        boolean isValid = true;
        if (!checkGenreNameToValidation(genreMap.get(GENRE_NAME))) {
            logger.info("genre name is not valid");
            genreMap.put(WORN_GENRE_NAME, ERROR_GENRE_NAME);
            isValid = false;
        }
        return isValid;
    }

}
