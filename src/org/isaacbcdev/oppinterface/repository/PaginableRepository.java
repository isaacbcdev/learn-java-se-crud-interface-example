package org.isaacbcdev.oppinterface.repository;

import org.isaacbcdev.oppinterface.model.Client;

import java.util.List;

public interface PaginableRepository {

    List<Client> listAll(int from, int to);

}