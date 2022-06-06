package epam.project.bookshop.service.impl;

import epam.project.bookshop.entity.Author;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.AuthorService;

import java.util.List;
import java.util.Optional;

public class AuthorServiceImpl implements AuthorService {
    private static final AuthorServiceImpl instance = new AuthorServiceImpl();

    private AuthorServiceImpl(){

    }

    public static AuthorServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean add(Author entity) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public void update(Author entity) {

    }

    @Override
    public List<Author> findAll() throws ServiceException {
        return null;
    }

    @Override
    public Optional<Author> findById(Long id) throws ServiceException {
        return Optional.empty();
    }
}
