package org.isaacbcdev.oppinterface;

import org.isaacbcdev.oppinterface.model.Client;
import org.isaacbcdev.oppinterface.repository.Direction;
import org.isaacbcdev.oppinterface.repository.OrdenablePaginableContableCrudRepository;
import org.isaacbcdev.oppinterface.repository.exceptions.DataAccessException;
import org.isaacbcdev.oppinterface.repository.exceptions.ReadingAccessDataException;
import org.isaacbcdev.oppinterface.repository.list.ClientListRepository;

import java.util.List;

public class ClientRepositoryExample {
    public static void main(String[] args) {
        try {
            OrdenablePaginableContableCrudRepository<Client> repository = new ClientListRepository();

            repository.save(new Client("Isaac", "Badel"));
            repository.save(new Client("John", "Doe"));
            repository.save(new Client("Mark", "White"));
            repository.save(new Client("Chris", "Li"));

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
            repository.update(johnDoe);

            Client john = repository.getById(2);
            System.out.println(john);

            System.out.println("================");
            repository.listAll("lastname", Direction.DESC).forEach(System.out::println);

            System.out.println("===== delete =====");
            repository.delete(2);
            repository.listAll().forEach(System.out::println);

            System.out.println("===== total =====");
            System.out.println("Total records: " + repository.total());
        } catch (ReadingAccessDataException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}