package epam.project.bookshop.service.impl;

import epam.project.bookshop.dao.AuthorDao;
import epam.project.bookshop.dao.GenreDao;
import epam.project.bookshop.dao.impl.AuthorDaoImpl;
import epam.project.bookshop.dao.impl.GenreDaoImpl;
import epam.project.bookshop.entity.Author;
import epam.project.bookshop.exception.DaoException;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.AuthorService;
import epam.project.bookshop.validation.AuthorValidation;
import epam.project.bookshop.validation.GenreValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AuthorServiceImpl implements AuthorService {
    private static final Logger logger = LogManager.getLogger();
    private static final AuthorDao authorDao = AuthorDaoImpl.getInstance();
    private static final AuthorValidation authorValidation = AuthorValidation.getInstance();
    private static final AuthorServiceImpl instance = new AuthorServiceImpl();

    private AuthorServiceImpl(){

    }

    public static AuthorServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public void update(Author entity) {

    }

    @Override
    public boolean update(Map<String, String> update) throws ServiceException {
        return false;
    }

    @Override
    public List<Author> findAll() throws ServiceException {

        try {
            return authorDao.findAll();
        } catch (DaoException e) {
            logger.info(e);
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Author> findById(Long id) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public boolean add(Map<String, String> entity) throws ServiceException {
        return false;
    }
}
