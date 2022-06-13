package epam.project.bookshop.dao;

import epam.project.bookshop.entity.User;
import epam.project.bookshop.exception.DaoException;

import java.util.Optional;

public interface UserDao extends BaseDao<User>{

    Optional<User> findByUsername(String username) throws DaoException;

    Optional<Long> findUserRoleByUsername(String username) throws DaoException;


}
