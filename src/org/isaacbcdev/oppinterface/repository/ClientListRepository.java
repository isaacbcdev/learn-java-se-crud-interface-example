package org.isaacbcdev.oppinterface.repository;

import org.isaacbcdev.oppinterface.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientListRepository implements OrdenablePaginableContableCrudRepository {

    private List<Client> dataSource;

    public ClientListRepository() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<Client> listAll() {
        return dataSource;
    }

    @Override
    public Client getById(Integer id) {
        Client client = null;
        for (Client c : dataSource) {
            if (c.getId() != null && c.getId().equals(id)) {
                client = c;
                break;
            }
        }

        return client;
    }

    @Override
    public void saveClient(Client client) {
        this.dataSource.add(client);
    }

    @Override
    public void updateClient(Client client) {
        Client c = this.getById(client.getId());

        c.setName(client.getName());
        c.setLastname(client.getLastname());
    }

    @Override
    public void delete(Integer id) {
        Client c = this.getById(id);
        this.dataSource.remove(c);
    }

    @Override
    public List<Client> listAll(String field, Direction dir) {
        List<Client> ordenable = new ArrayList<>(this.dataSource);
        ordenable.sort((Client a, Client b) -> {
            int result = 0;
            if (dir == Direction.ASC) {
                result = sort(field, a, b);
            } else if (dir == Direction.DESC) {
                result = sort(field, a, b);
            }
            return result;
        });

        return ordenable;
    }

    @Override
    public List<Client> listAll(int from, int to) {
        return dataSource.subList(from, to);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }

    public static int sort(String field, Client a, Client b) {
        int result = 0;

        switch (field) {
            case "id" -> result = a.getId().compareTo(b.getId());
            case "name" -> result = a.getName().compareTo(b.getName());
            case "lastname" -> result = a.getLastname().compareTo(b.getLastname());
        }

        return result;
    }
}