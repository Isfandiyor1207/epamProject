package epam.project.bookshop.dao.impl;

import epam.project.bookshop.dao.UserDao;
import epam.project.bookshop.entity.User;
import epam.project.bookshop.exception.DaoException;
import epam.project.bookshop.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    static Logger logger = LogManager.getLogger();

    private static final String SELECT_BY_USERNAME = "SELECT id, firstname, lastname, password, phoneNumber, email, username FROM users WHERE username = ? AND deleted = false";
    private static final String SELECT_BY_ID = "SELECT id, firstname, lastname, phoneNumber, email, username FROM users WHERE  id = ? AND deleted = false";
    private static final String SELECT_ALL = "SELECT id, firstname, lastname, phoneNumber, email, username, roleid FROM  users WHERE deleted=false order by id";
    private static final String SELECT_ROLE_ID = "SELECT roleid FROM users WHERE username = ? AND deleted=false;";
    private static final String DELETE_USERS_BY_ID = "UPDATE users SET deleted = true WHERE id =? AND deleted = false";
    private static final String INSERT_USER = "INSERT INTO users(firstname, lastname, username, password, email, phoneNumber) VALUES (?, ?, ?, ?, ?, ?)";
    private static UserDaoImpl instance;

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public boolean save(User user) throws DaoException {

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_USER)) {

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPhoneNumber());

            int numberOfRow = statement.executeUpdate();

            return numberOfRow > 0;
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
    }

    @Override
    public boolean updated(User user) throws DaoException {

        return false;
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_BY_ID)) {

            int resultSet = 0;
            if (findById(id).isPresent()) {
                statement.setObject(1, id);
                resultSet = statement.executeUpdate();
            }
            return resultSet > 0;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<User> findById(Long id) throws DaoException {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            User user = new User();
            while (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("firstname"));
                user.setUsername(resultSet.getString("username"));
                user.setLastName(resultSet.getString("lastname"));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getString("phoneNumber"));
            }

            return Optional.of(user);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<User> findAll() throws DaoException {
        List<User> userList = new ArrayList<>();

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_ALL);

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("firstname"));
                user.setUsername(resultSet.getString("username"));
                user.setLastName(resultSet.getString("lastname"));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getString("phonenumber"));
                user.setRoleId(resultSet.getLong("roleid"));
                userList.add(user);
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return userList;
    }

    @Override
    public Optional<User> findByUsername(String username) throws DaoException {

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_USERNAME)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            User user = new User();
            while (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("firstname"));
                user.setUsername(resultSet.getString("username"));
                user.setLastName(resultSet.getString("lastname"));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getString("phonenumber"));
                user.setPassword(resultSet.getString("password"));
            }

            logger.info("user in dao " + user);

            if (user.getId() != null) {
                return Optional.of(user);
            } else return Optional.empty();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<Long> findUserRoleByUsername(String username) throws DaoException {

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ROLE_ID)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            Long role = null;
            while (resultSet.next()) {
                role = resultSet.getLong("roleid");
            }

            logger.info("role id:" + role);
            return Optional.of(role);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

}
