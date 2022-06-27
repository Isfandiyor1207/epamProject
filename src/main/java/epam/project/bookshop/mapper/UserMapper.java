package epam.project.bookshop.mapper;

import epam.project.bookshop.entity.User;
import epam.project.bookshop.exception.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;

import static epam.project.bookshop.command.ParameterName.*;

public class UserMapper implements BaseMapper<User> {

    private static final UserMapper instance = new UserMapper();

    public static UserMapper getInstance() {
        return instance;
    }

    @Override
    public User resultSetToEntity(ResultSet resultSet) throws DaoException {
        User user = new User();
        try {
            user.setId(resultSet.getLong(ID));
            user.setFirstName(resultSet.getString(FIRSTNAME));
            user.setUsername(resultSet.getString(USERNAME));
            user.setLastName(resultSet.getString(LASTNAME));
            user.setEmail(resultSet.getString(EMAIL));
            user.setPhoneNumber(resultSet.getString(USER_PHONE_NUMBER_IN_DB));
            user.setRoleId(resultSet.getLong(USER_ROLE_ID));
            user.setPassword(resultSet.getString(PASSWORD));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return user;
    }

}
