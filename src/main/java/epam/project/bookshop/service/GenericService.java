package epam.project.bookshop.service;

import epam.project.bookshop.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {
    boolean add(T entity) throws ServiceException;

    boolean deleteById(Long id) throws ServiceException;

    void update(T entity) throws ServiceException;

    List<T> findAll() throws ServiceException;

    Optional<T> findById(Long id) throws ServiceException;

}
