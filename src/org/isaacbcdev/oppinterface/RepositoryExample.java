package org.isaacbcdev.oppinterface;

import org.isaacbcdev.oppinterface.model.Client;
import org.isaacbcdev.oppinterface.repository.ClientListRepository;
import org.isaacbcdev.oppinterface.repository.Direction;
import org.isaacbcdev.oppinterface.repository.OrdenablePaginableContableCrudRepository;

import java.util.List;

public class RepositoryExample {
    public static void main(String[] args) {
        OrdenablePaginableContableCrudRepository repository = new ClientListRepository();

        repository.saveClient(new Client("Isaac", "Badel"));
        repository.saveClient(new Client("John", "Doe"));
        repository.saveClient(new Client("Mark", "White"));
        repository.saveClient(new Client("Chris", "Li"));

        List<Client> clients = repository.listAll();
        clients.forEach(System.out::println);

        System.out.println("===== paginable =====");
        List<Client> paginable = repository.listAll(0, 4);
        paginable.forEach(System.out::println);

        System.out.println("===== ordenable =====");
        List<Client> ordenable = repository.listAll("lastname", Direction.DESC);
        ordenable.forEach(System.out::println);

        System.out.println("===== update =====");
        Client johnDoe = new Client("John", "Clark");
        johnDoe.setId(2);
        repository.updateClient(johnDoe);

        Client john = repository.getById(2);
        System.out.println(john);

        System.out.println("================");
        repository.listAll("lastname", Direction.DESC).forEach(System.out::println);

        System.out.println("===== delete =====");
        repository.delete(2);
        repository.listAll().forEach(System.out::println);

        System.out.println("===== total =====");
        System.out.println("Total records: " + repository.total());
    }
}