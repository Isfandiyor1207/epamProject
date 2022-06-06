package epam.project.bookshop.dao;

import epam.project.bookshop.entity.Genre;
import epam.project.bookshop.exception.DaoException;

import java.util.Optional;

public interface GenreDao extends BaseDao<Genre>{
    Optional<Genre> findByName(String name) throws DaoException;
}
