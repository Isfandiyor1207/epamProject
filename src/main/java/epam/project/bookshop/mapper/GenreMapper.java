package epam.project.bookshop.mapper;

import epam.project.bookshop.entity.Genre;
import epam.project.bookshop.exception.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;

import static epam.project.bookshop.command.ParameterName.GENRE_NAME;
import static epam.project.bookshop.command.ParameterName.ID;

public class GenreMapper implements BaseMapper<Genre> {

    private static final GenreMapper instance = new GenreMapper();

    private GenreMapper(){}

    public static GenreMapper getInstance() {
        return instance;
    }

    @Override
    public Genre resultSetToEntity(ResultSet resultSet) throws DaoException {
        Genre genre = new Genre();
        try {
            genre.setId(resultSet.getLong(ID));
            genre.setName(resultSet.getString(GENRE_NAME));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return genre;
    }
}
