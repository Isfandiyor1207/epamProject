package epam.project.bookshop.mapper;

import epam.project.bookshop.exception.DaoException;

import java.sql.ResultSet;

public interface BaseMapper<T>{
    T resultSetToEntity(ResultSet resultSet) throws DaoException;
}
