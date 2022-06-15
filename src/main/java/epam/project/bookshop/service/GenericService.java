package epam.project.bookshop.service;

import epam.project.bookshop.exception.ServiceException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GenericService<T> {

    boolean deleteById(Long id) throws ServiceException;

    void update(T entity) throws ServiceException;

    void update(Map<String, String> update) throws ServiceException;

    List<T> findAll() throws ServiceException;

    Optional<T> findById(Long id) throws ServiceException;

    boolean add(Map<String, String> entity) throws ServiceException;
}
