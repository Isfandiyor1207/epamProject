package epam.project.bookshop.service.impl;

import epam.project.bookshop.entity.Genre;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.GenreService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GenreServiceImpl implements GenreService {
    private static final GenreServiceImpl instance = new GenreServiceImpl();

    private GenreServiceImpl() {
    }

    public static GenreServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public void update(Genre entity) {

    }

    @Override
    public boolean update(Map<String, String> update) throws ServiceException {
        return false;
    }

    @Override
    public List<Genre> findAll() throws ServiceException {
        return null;
    }

    @Override
    public Optional<Genre> findById(Long id) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public boolean add(Map<String, String> entity) throws ServiceException {
        return false;
    }
}
