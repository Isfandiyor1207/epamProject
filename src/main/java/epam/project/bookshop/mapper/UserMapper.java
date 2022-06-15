package epam.project.bookshop.mapper;

import epam.project.bookshop.entity.User;
import epam.project.bookshop.exception.DaoException;
import epam.project.bookshop.exception.ServiceException;

import java.sql.ResultSet;
import java.sql.SQLException;

import static epam.project.bookshop.command.ParameterName.*;

public class UserMapper {

    public static User resultSetToUser(ResultSet resultSet) throws DaoException {
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
