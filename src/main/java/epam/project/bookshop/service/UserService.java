package epam.project.bookshop.service;

import epam.project.bookshop.entity.User;
import epam.project.bookshop.exception.ServiceException;

import java.util.Map;

public interface UserService extends GenericService<User> {

    boolean authenticate(Map<String, String> userLogin) throws ServiceException;

    Long findUserRoleByUsername(String username) throws ServiceException;
}
