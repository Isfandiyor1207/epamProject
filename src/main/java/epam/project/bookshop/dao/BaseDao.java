package epam.project.bookshop.dao;

import epam.project.bookshop.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T> {
    boolean save(T t) throws DaoException;

    boolean updated(T t) throws DaoException;

    boolean deleteById(Long id) throws DaoException;

    Optional<T> findById(Long id) throws DaoException;

    List<T> findAll() throws DaoException;

}
