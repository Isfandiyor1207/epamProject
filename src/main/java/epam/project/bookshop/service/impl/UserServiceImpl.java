package epam.project.bookshop.service.impl;

import epam.project.bookshop.command.ParameterName;
import epam.project.bookshop.command.WebPageName;
import epam.project.bookshop.dao.impl.UserDaoImpl;
import epam.project.bookshop.entity.User;
import epam.project.bookshop.exception.DaoException;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.UserService;
import epam.project.bookshop.validation.BaseValidation;
import epam.project.bookshop.validation.RegistrationValidation;
import epam.project.bookshop.validation.ValidationParameterName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static epam.project.bookshop.command.ParameterName.*;
import static epam.project.bookshop.validation.ValidationParameterName.ERROR_USERNAME_MSG;
import static epam.project.bookshop.validation.ValidationParameterName.WRONG_USERNAME;

public class UserServiceImpl implements UserService {
    static Logger logger = LogManager.getLogger();
    private static final UserServiceImpl instance = new UserServiceImpl();
    private final UserDaoImpl userDao = UserDaoImpl.getInstance();
    private final RegistrationValidation registrationValidation=RegistrationValidation.getInstance();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public Long authenticate(String login, String password) throws ServiceException {

        Optional<User> dao;

        BaseValidation validation = new BaseValidation();
        if (validation.isEmpty(login) && validation.isEmpty(password)) {
            return -1L;
        } else {
            try {
                dao = userDao.findByUsername(login);
                if (dao.isPresent()) {
                    return dao.get().getUsername().equals(login) && dao.get().getPassword().equals(password) ? dao.get().getRoleId() : -1;
                } else {
                    throw new ServiceException("User by this username is not exist");
                }
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
    }

    @Override
    public boolean add(Map<String, String> userData) throws ServiceException {
        // todo check to validation email password username phoneNumber

        if (!registrationValidation.userRegistrationValidation(userData)){
            logger.info("user in userservice");
            return false;
        }

        try {
            Optional<User> byUsername = userDao.findByUsername(userData.get(USERNAME));
            if (byUsername.isPresent()){
                userData.put(WRONG_USERNAME, ERROR_USERNAME_MSG);
                return false;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        User user = new User();
        user.setFirstName(userData.get(FIRSTNAME));
        user.setLastName(userData.get(LASTNAME));
        user.setUsername(userData.get(USERNAME));
        user.setEmail(userData.get(EMAIL));
        user.setPassword(userData.get(PASSWORD));
        user.setPhoneNumber(userData.get(PHONE_NUMBER));

        try {
            boolean save = userDao.save(user);
            logger.info("check user to add" + save);
            return save;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean add(User entity) throws ServiceException {
        return false;
    }

    @Override
    public boolean deleteById(Long id) throws ServiceException {
        try {
            return userDao.deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public List<User> findAll() throws ServiceException {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) throws ServiceException {
        return Optional.empty();
    }

}
