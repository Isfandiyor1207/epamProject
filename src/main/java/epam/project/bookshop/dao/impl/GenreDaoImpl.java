package epam.project.bookshop.dao.impl;

import epam.project.bookshop.dao.GenreDao;
import epam.project.bookshop.entity.Genre;
import epam.project.bookshop.exception.DaoException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class GenreDaoImpl implements GenreDao {

    static GenreDaoImpl instance;

    public static GenreDaoImpl getInstance() {
        if (instance == null) {
            instance = new GenreDaoImpl();
        }
        return instance;
    }

    @Override
    public boolean save(Genre genre) throws DaoException {
        return false;
    }

    @Override
    public boolean updated(Genre genre) throws DaoException {
        return false;
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        return false;
    }

    @Override
    public Optional<Genre> findById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<Genre> findAll() throws DaoException {
        return null;
    }

    @Override
    public Optional<Genre> findByName(String name) throws DaoException {
        return Optional.empty();
    }
}
