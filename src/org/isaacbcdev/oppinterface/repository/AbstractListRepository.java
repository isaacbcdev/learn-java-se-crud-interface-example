package org.isaacbcdev.oppinterface.repository;

import org.isaacbcdev.oppinterface.model.BaseEntity;
import org.isaacbcdev.oppinterface.repository.exceptions.DuplicatedRecordAccessDataException;
import org.isaacbcdev.oppinterface.repository.exceptions.ReadingAccessDataException;
import org.isaacbcdev.oppinterface.repository.exceptions.WritingAccessDataException;

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
    public T getById(Integer id) throws ReadingAccessDataException {
        if (id == null || id <= 0) {
            throw new ReadingAccessDataException("Invalid ID, it must be greater than 0.");
        }
        T t = null;
        for (T c : dataSource) {
            if (c.getId() != null && c.getId().equals(id)) {
                t = c;
                break;
            }
        }

        if (t == null) {
            throw new ReadingAccessDataException("There is no record with ID:" + id);
        }

        return t;
    }

    @Override
    public void save(T t) throws WritingAccessDataException {
        if (t == null) {
            throw new WritingAccessDataException("You can create a null record.");
        }
        if (this.dataSource.contains(t)) {
            throw new DuplicatedRecordAccessDataException("The record with ID: " + t.getId() + " is already stored.");
        }
        this.dataSource.add(t);
    }

    @Override
    public void delete(Integer id) throws ReadingAccessDataException {
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