package org.isaacbcdev.oppinterface.repository.list;

import org.isaacbcdev.oppinterface.model.Client;
import org.isaacbcdev.oppinterface.repository.AbstractListRepository;
import org.isaacbcdev.oppinterface.repository.Direction;

import java.util.ArrayList;
import java.util.List;

public class ClientListRepository extends AbstractListRepository<Client> {
    @Override
    public void update(Client client) {
        Client c = this.getById(client.getId());

        c.setName(client.getName());
        c.setLastname(client.getLastname());
    }

    @Override
    public List<Client> listAll(String field, Direction dir) {
        List<Client> ordenable = new ArrayList<>(this.dataSource);
        ordenable.sort((Client a, Client b) -> {
            int result = 0;
            if (dir == Direction.ASC) {
                result = sort(field, a, b);
            } else if (dir == Direction.DESC) {
                result = sort(field, b, a);
            }
            return result;
        });

        return ordenable;
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