package epam.project.bookshop.service;

import epam.project.bookshop.entity.User;
import epam.project.bookshop.exception.ServiceException;

import java.util.Map;

public interface UserService extends GenericService<User> {
    Long authenticate(String login, String password) throws ServiceException;
}
