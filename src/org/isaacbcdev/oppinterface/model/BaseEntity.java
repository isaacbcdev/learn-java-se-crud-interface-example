package org.isaacbcdev.oppinterface.model;

import java.util.Objects;

public class BaseEntity {

    protected Integer id;

    private static Integer lastId = 0;

    public BaseEntity() {
        this.id = ++lastId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity baseEntity = (BaseEntity) o;
        return Objects.equals(id, baseEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}