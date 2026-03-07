package org.isaacbcdev.oppinterface.repository;

import org.isaacbcdev.oppinterface.repository.exceptions.DataAccessException;

import java.util.List;

public interface CrudRepository<T> {
    List<T> listAll();

    T getById(Integer id) throws DataAccessException;

    void save(T t) throws DataAccessException;

    void update(T t) throws DataAccessException;

    void delete(Integer id) throws DataAccessException;
}