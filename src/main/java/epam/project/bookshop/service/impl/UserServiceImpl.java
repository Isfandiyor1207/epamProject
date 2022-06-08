package epam.project.bookshop.service.impl;

import epam.project.bookshop.dao.impl.UserDaoImpl;
import epam.project.bookshop.entity.User;
import epam.project.bookshop.exception.DaoException;
import epam.project.bookshop.exception.ServiceException;
import epam.project.bookshop.service.UserService;
import epam.project.bookshop.validation.BaseValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    static Logger logger = LogManager.getLogger();
    private static final UserServiceImpl instance = new UserServiceImpl();
    private final UserDaoImpl userDao = UserDaoImpl.getInstance();

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
    public boolean add(User user) throws ServiceException {
        // todo check to validation email password username phoneNumber

        System.out.println(user);
        String password = user.getPassword();

//        RegistrationValidation validation = new RegistrationValidation();

//        if (!validation.checkEmailValidation(user.getEmail())) { // fixme how Throw Email is not correct to login page from there
//            return false;
//        }
//
//        if (!validation.checkPasswordToValidation(password)) { // fixme how Throw Email is not correct to login page from there
//            return false;
//        }
//
//        if (!validation.checkPhoneNumberToValidation(user.getPhoneNumber())) {
//            return false;
//        }

//        user.setPassword(Arrays.toString(DigestUtils.md5(password)));
        try {
            boolean save = userDao.save(user);
            logger.info("check user to add" + save);
            return save;
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
    public List<User> findAll() throws ServiceException {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) throws ServiceException {
        return Optional.empty();
    }

}
