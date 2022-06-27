package epam.project.bookshop.dao.impl;

import epam.project.bookshop.dao.AuthorDao;
import epam.project.bookshop.entity.Author;
import epam.project.bookshop.exception.DaoException;
import epam.project.bookshop.mapper.AuthorMapper;
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
public class AuthorDaoImpl implements AuthorDao {

    public static final Logger logger = LogManager.getLogger();

    private static final String SELECT_BY_AUTHOR_NAME = "SELECT id, firstname, lastname FROM author WHERE name = ? AND deleted = false";
    private static final String SELECT_BY_ID = "SELECT id, firstname, lastname FROM author WHERE  id = ? AND deleted = false";
    private static final String SELECT_ALL = "SELECT id, firstname, lastname FROM author WHERE deleted = false order by id";
    private static final String DELETE_AUTHOR_BY_ID = "UPDATE author SET deleted = true WHERE id =? AND deleted = false";
    private static final String UPDATE_AUTHOR_BY_ID = "UPDATE author SET %s WHERE id =%s AND deleted = false";
    private static final String INSERT_AUTHOR = "INSERT INTO author(firstname, lastname) VALUES (?, ?)";
    private static AuthorDaoImpl instance;

    public static AuthorDaoImpl getInstance() {
        if (instance == null) {
            instance = new AuthorDaoImpl();
        }
        return instance;
    }

    @Override
    public Optional<Author> findByFirstName(String firstName) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<Author> findByLastName(String lastName) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<Author> findByFio(String firstName, String lastName) throws DaoException {
        return Optional.empty();
    }

    @Override
    public boolean save(Author author) throws DaoException {
        return false;
    }

    @Override
    public boolean updated(String query, Long id) throws DaoException {
        return false;
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        return false;
    }

    @Override
    public Optional<Author> findById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<Author> findAll() throws DaoException {
        List<Author> authorList=new ArrayList<>();
        try(Connection connection=ConnectionPool.getInstance().getConnection();
            PreparedStatement statement=connection.prepareStatement(SELECT_ALL)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                authorList.add(AuthorMapper.getInstance().resultSetToEntity(resultSet));
            }

        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return authorList;
    }

}
