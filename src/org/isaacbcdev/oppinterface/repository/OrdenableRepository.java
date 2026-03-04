package org.isaacbcdev.oppinterface.repository;

import java.util.List;

public interface OrdenableRepository<T> {

    List<T> listAll(String field, Direction dir);
}