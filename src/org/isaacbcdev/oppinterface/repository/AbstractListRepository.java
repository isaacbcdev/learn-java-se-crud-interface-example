package org.isaacbcdev.oppinterface.repository;

import org.isaacbcdev.oppinterface.model.BaseEntity;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractListRepository<T extends BaseEntity> implements OrdenablePaginableContableCrudRepository<T> {

    protected List<T> dataSource;

    public AbstractListRepository() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listAll() {
        return dataSource;
    }

    @Override
    public T getById(Integer id) {
        T t = null;
        for (T c : dataSource) {
            if (c.getId() != null && c.getId().equals(id)) {
                t = c;
                break;
            }
        }

        return t;
    }

    @Override
    public void save(T t) {
        this.dataSource.add(t);
    }

    @Override
    public void delete(Integer id) {
        this.dataSource.remove(this.getById(id));
    }

    @Override
    public List<T> listAll(int from, int to) {
        return dataSource.subList(from, to);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}