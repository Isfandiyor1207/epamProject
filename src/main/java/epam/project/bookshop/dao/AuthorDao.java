package epam.project.bookshop.dao;

import epam.project.bookshop.entity.Author;
import epam.project.bookshop.exception.DaoException;

import java.util.Optional;

public interface AuthorDao extends BaseDao<Author> {

    Optional<Author> findByFirstName(String firstName) throws DaoException;

    Optional<Author> findByLastName(String lastName) throws DaoException;

    Optional<Author> findByFio(String firstName, String lastName) throws DaoException;
}
