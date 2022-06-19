package epam.project.bookshop.service.impl;

import epam.project.bookshop.dao.impl.UserDaoImpl;
import epam.project.bookshop.entity.User;
import epam.project.bookshop.exception.DaoException;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.UserService;
import epam.project.bookshop.validation.BaseValidation;
import epam.project.bookshop.validation.RegistrationValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static epam.project.bookshop.command.ParameterName.*;
import static epam.project.bookshop.validation.ValidationParameterName.*;

public class UserServiceImpl implements UserService {
    private static Logger logger = LogManager.getLogger();
    private static final BaseValidation baseValidation = new BaseValidation();
    private static final UserServiceImpl instance = new UserServiceImpl();
    private final UserDaoImpl userDao = UserDaoImpl.getInstance();
    private final RegistrationValidation registrationValidation = RegistrationValidation.getInstance();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean authenticate(Map<String, String> userLogin) throws ServiceException {
        Optional<User> dao;

        String username = userLogin.get(USERNAME);
        String password = userLogin.get(PASSWORD);

        BaseValidation validation = BaseValidation.getInstance();
        if (validation.isEmpty(username) || validation.isEmpty(password)) {
            logger.info("user in validation ");
            return false;
        }

        try {
            boolean isAuthenticated = true;

            dao = userDao.findByUsername(username);
            if (dao.isPresent()) {
                User user = dao.get();

                if (!user.getPassword().equals(password)) {
                    userLogin.put(WORN_LOGIN, ERROR_LOGIN_MSG);
                    isAuthenticated = false;
                }

                return isAuthenticated;
            } else {
                userLogin.put(WORN_USER, ERROR_USER_NOT_EXIST_MSG);
                return false;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Long findUserRoleByUsername(String username) throws ServiceException {
        try {
            Optional<Long> roleByUsername = userDao.findUserRoleByUsername(username);
            return roleByUsername.get();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean add(Map<String, String> userData) throws ServiceException {

        if (!registrationValidation.userRegistrationValidation(userData)) {
            logger.info("user is not registered his information is invalid");
            return false;
        }

        try {
            Optional<User> optionalUser = userDao.findByUsername(userData.get(USERNAME));
            if (optionalUser.isPresent()) {
                logger.info(optionalUser.get().getUsername() + " is available in database");
                userData.put(WORN_USERNAME, ERROR_USERNAME_MSG);
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
            boolean isSave = userDao.save(user);
            logger.info("check user to add" + isSave);
            return isSave;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
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
    public boolean update(Map<String, String> update) throws ServiceException {

        Map<String, String> query=new HashMap<>();

        boolean isValid = registrationValidation.checkUpdateUser(update, query);

        if (!isValid){
            return false;
        }

        if (baseValidation.isEmpty(update.get(USERNAME))){
            try {
                Optional<User> optionalUser = userDao.findByUsername(update.get(USERNAME));
                if (optionalUser.isPresent()){
                    update.put(WORN_USERNAME, ERROR_USERNAME_MSG);
                    return false;
                }
            } catch (DaoException e) {
                logger.error(e);
                throw new ServiceException(e);
            }

        }

        StringBuilder stringBuilder=new StringBuilder();

        query.forEach((key, value) -> stringBuilder.append(key)
                .append("=")
                .append(key)
                .append(", "));

        try {
            return userDao.updated(stringBuilder.toString(), 2L);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findAll() throws ServiceException {
        try {
            return userDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> findById(Long id) throws ServiceException {
        return Optional.empty();
    }

}
