package org.isaacbcdev.oppinterface.repository;

import org.isaacbcdev.oppinterface.model.Client;

import java.util.List;

public interface OrdenableRepository {

    List<Client> listAll(String field, Direction dir);
}