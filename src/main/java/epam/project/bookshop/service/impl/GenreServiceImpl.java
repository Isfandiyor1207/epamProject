package epam.project.bookshop.service.impl;

import epam.project.bookshop.dao.GenreDao;
import epam.project.bookshop.dao.impl.GenreDaoImpl;
import epam.project.bookshop.entity.Genre;
import epam.project.bookshop.exception.DaoException;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.GenreService;
import epam.project.bookshop.validation.GenreValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static epam.project.bookshop.command.ParameterName.GENRE_NAME;
import static epam.project.bookshop.command.ParameterName.ID;
import static epam.project.bookshop.validation.ValidationParameterName.ERROR_GENRE_NAME_EXIST;
import static epam.project.bookshop.validation.ValidationParameterName.WORN_GENRE_NAME;

public class GenreServiceImpl implements GenreService {
    private static final Logger logger = LogManager.getLogger();
    private static final GenreServiceImpl instance = new GenreServiceImpl();
    private static final GenreDao genreDao = GenreDaoImpl.getInstance();
    private final GenreValidation genreValidation = GenreValidation.getInstance();

    private GenreServiceImpl() {
    }

    public static GenreServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean deleteById(Long id) throws ServiceException {
        try {
            return genreDao.deleteById(id);
        } catch (DaoException e) {
            logger.error("Genre does not deleted by this name!");
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(Genre entity) {

    }

    @Override
    public boolean update(Map<String, String> genreMapper) throws ServiceException {
        if (!genreValidation.genreValidation(genreMapper)) {
            logger.info("Genre information is not valid!");
            return false;
        }
        try {
            Optional<Genre> optionalGenre = genreDao.findById(Long.valueOf(genreMapper.get(ID)));
            if (optionalGenre.isPresent()) {
                logger.info(optionalGenre.get() + " is available in database");
                genreMapper.put(WORN_GENRE_NAME, ERROR_GENRE_NAME_EXIST);
                return false;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        Genre genre = new Genre();
        genre.setName(genreMapper.get(GENRE_NAME));

        try {
            return genreDao.save(genre);
        } catch (DaoException e) {
            logger.error("Genre is not added to database.");
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Genre> findAll() throws ServiceException {
        try {
            return genreDao.findAll();
        } catch (DaoException e) {
            logger.error("Genre find all method is failed!");
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Genre> findById(Long id) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public boolean add(Map<String, String> entity) throws ServiceException {
        if (!genreValidation.genreValidation(entity)) {
            logger.info("Genre information is not valid!");
            return false;
        }
        try {
            Optional<Genre> optionalGenre = genreDao.findByName(entity.get(GENRE_NAME));
            if (optionalGenre.isPresent()) {
                logger.info(optionalGenre.get() + " is available in database");
                entity.put(WORN_GENRE_NAME, ERROR_GENRE_NAME_EXIST);
                return false;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        Genre genre = new Genre();
        genre.setName(entity.get(GENRE_NAME));

        try {
            return genreDao.save(genre);
        } catch (DaoException e) {
            logger.error("Genre is not added to database.");
            throw new ServiceException(e);
        }

    }
}
