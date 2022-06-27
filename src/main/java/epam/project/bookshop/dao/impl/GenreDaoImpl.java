package epam.project.bookshop.dao.impl;

import epam.project.bookshop.dao.GenreDao;
import epam.project.bookshop.entity.Genre;
import epam.project.bookshop.exception.DaoException;
import epam.project.bookshop.mapper.GenreMapper;
import epam.project.bookshop.pool.ConnectionPool;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class GenreDaoImpl implements GenreDao {

    public static final Logger logger = LogManager.getLogger();

    private static final String SELECT_BY_GENRE_NAME = "SELECT id, name FROM genre WHERE name = ? AND deleted = false";
    private static final String SELECT_BY_ID = "SELECT id, name FROM genre WHERE  id = ? AND deleted = false";
    private static final String SELECT_ALL = "SELECT id, name FROM genre WHERE deleted = false order by id";
    private static final String DELETE_GENRE_BY_ID = "UPDATE genre SET deleted = true WHERE id =? AND deleted = false";
    private static final String UPDATE_GENRE_BY_ID = "UPDATE genre SET %s WHERE id =%s AND deleted = false";
    private static final String INSERT_GENRE = "INSERT INTO genre(name) VALUES (?)";

    private static GenreDaoImpl instance;

    public static GenreDaoImpl getInstance() {
        if (instance == null) {
            instance = new GenreDaoImpl();
        }
        return instance;
    }

    @Override
    public boolean save(Genre genre) throws DaoException {

        try (PreparedStatement statement = createConnection().prepareStatement(INSERT_GENRE)) {

            statement.setString(1, genre.getName());
            int numberOfRow = statement.executeUpdate();

            return numberOfRow > 0;
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    @Override
    public boolean updated(String query, Long id) throws DaoException {
        return false;
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        try (PreparedStatement statement = createConnection().prepareStatement(DELETE_GENRE_BY_ID)) {

            int resultSet = 0;
            if (findById(id).isPresent()) {
                statement.setObject(1, id);
                resultSet = statement.executeUpdate();
            }
            return resultSet > 0;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<Genre> findById(Long id) throws DaoException {

        try (PreparedStatement statement = createConnection().prepareStatement(SELECT_BY_ID)) {

            statement.setObject(1, id);

            ResultSet resultSet = statement.executeQuery();
            Genre genre = new Genre();
            while (resultSet.next()) {
                genre = GenreMapper.getInstance().resultSetToEntity(resultSet);
            }

            if (genre.getName() != null) {
                return Optional.of(genre);
            } else return Optional.empty();

        } catch (SQLException e) {
            logger.info("Genre not found!");
            throw new DaoException(e);
        }
    }

    @Override
    public List<Genre> findAll() throws DaoException {
        List<Genre> genreList = new ArrayList<>();

        try (PreparedStatement statement = createConnection().prepareStatement(SELECT_ALL)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                genreList.add(GenreMapper.getInstance().resultSetToEntity(resultSet));
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return genreList;
    }

    @Override
    public Optional<Genre> findByName(String name) throws DaoException {

        try (PreparedStatement statement = createConnection().prepareStatement(SELECT_BY_GENRE_NAME)) {

            statement.setObject(1, name);

            ResultSet resultSet = statement.executeQuery();
            Genre genre = new Genre();

            while (resultSet.next()) {
                genre = GenreMapper.getInstance().resultSetToEntity(resultSet);
            }
            logger.info(genre);

            if (genre.getName() != null) {
                return Optional.of(genre);
            } else return Optional.empty();

        } catch (SQLException e) {
            logger.info("Genre not found!");
            throw new DaoException(e);
        }
    }

    private Connection createConnection() {
        return ConnectionPool.getInstance().getConnection();
    }

}
