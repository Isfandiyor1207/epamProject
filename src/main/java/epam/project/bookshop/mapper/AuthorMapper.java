package epam.project.bookshop.mapper;

import epam.project.bookshop.entity.Author;
import epam.project.bookshop.entity.Genre;
import epam.project.bookshop.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

import static epam.project.bookshop.command.ParameterName.*;

public class AuthorMapper implements BaseMapper<Author>{
    private static final Logger logger= LogManager.getLogger();
    private static final AuthorMapper instance = new AuthorMapper();

    private AuthorMapper(){}

    public static AuthorMapper getInstance() {
        return instance;
    }

    @Override
    public Author resultSetToEntity(ResultSet resultSet) throws DaoException {
        Author author = new Author();
        try {
            author.setId(resultSet.getLong(ID));
            author.setFirstname(resultSet.getString(FIRSTNAME));
            author.setFirstname(resultSet.getString(LASTNAME));
        } catch (SQLException e) {
            logger.info(e);
            throw new DaoException(e);
        }
        return author;
    }
}
