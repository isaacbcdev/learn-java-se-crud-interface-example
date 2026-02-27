package org.isaacbcdev.oppinterface.repository;

import org.isaacbcdev.oppinterface.model.Client;

import java.util.List;

public interface CrudRepository {
    List<Client> listAll();

    Client getById(Integer id);

    void saveClient(Client client);

    void updateClient(Client client);

    void delete(Integer id);
}