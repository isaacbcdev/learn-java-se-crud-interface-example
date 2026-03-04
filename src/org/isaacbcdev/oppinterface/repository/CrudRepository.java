package org.isaacbcdev.oppinterface.repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> listAll();

    T getById(Integer id);

    void save(T t);

    void update(T t);

    void delete(Integer id);
}