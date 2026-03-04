package org.isaacbcdev.oppinterface.repository;

public interface OrdenablePaginableContableCrudRepository<T> extends OrdenableRepository<T>, CrudRepository<T>, PaginableRepository<T>, CountableRepository {

}