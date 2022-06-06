package epam.project.bookshop.service.impl;

import epam.project.bookshop.entity.Book;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.BookService;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {
    private static final BookServiceImpl instance = new BookServiceImpl();

    private BookServiceImpl() {
    }

    public static BookServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean add(Book entity) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public void update(Book entity) {

    }

    @Override
    public List<Book> findAll() throws ServiceException {
        return null;
    }

    @Override
    public Optional<Book> findById(Long id) throws ServiceException {
        return Optional.empty();
    }
}
