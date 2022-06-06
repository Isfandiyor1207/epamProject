package epam.project.bookshop.service;

import epam.project.bookshop.entity.User;
import epam.project.bookshop.exception.ServiceException;

public interface UserService extends GenericService<User> {
    boolean authenticate(String login, String password) throws ServiceException;

}
