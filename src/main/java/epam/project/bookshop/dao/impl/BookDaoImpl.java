package epam.project.bookshop.dao.impl;

import epam.project.bookshop.dao.BookDao;
import epam.project.bookshop.entity.Book;
import epam.project.bookshop.exception.DaoException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDaoImpl implements BookDao {

    static BookDaoImpl instance;

    public static BookDaoImpl getInstance() {
        if (instance == null) {
            instance = new BookDaoImpl();
        }
        return instance;
    }

    @Override
    public boolean save(Book book) throws DaoException {
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
    public Optional<Book> findById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public List<Book> findAll() throws DaoException {
        return null;
    }

    @Override
    public Optional<Book> findByName(String name) throws DaoException {
        return Optional.empty();
    }
}
