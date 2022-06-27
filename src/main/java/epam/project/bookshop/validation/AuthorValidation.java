package epam.project.bookshop.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthorValidation {
    private static final Logger logger = LogManager.getLogger();

    private static final String GENRE_NAME_REGEX = "[a-zA-Z]+";
    private static final AuthorValidation instance = new AuthorValidation();
    private static final BaseValidation baseValidation = BaseValidation.getInstance();

    private AuthorValidation(){}

    public static AuthorValidation getInstance() {
        return instance;
    }



}
