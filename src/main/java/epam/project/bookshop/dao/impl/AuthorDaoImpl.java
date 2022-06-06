package epam.project.bookshop.dao.impl;

import epam.project.bookshop.dao.AuthorDao;
import epam.project.bookshop.entity.Author;
import epam.project.bookshop.exception.DaoException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorDaoImpl implements AuthorDao {

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
    public boolean updated(Author author) throws DaoException {
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
        return null;
    }
}
