package org.isaacbcdev.oppinterface;

import org.isaacbcdev.oppinterface.model.Product;
import org.isaacbcdev.oppinterface.repository.Direction;
import org.isaacbcdev.oppinterface.repository.OrdenablePaginableContableCrudRepository;
import org.isaacbcdev.oppinterface.repository.list.ProductListRepository;

import java.util.List;

public class ProductRepositoryExample {
    public static void main(String[] args) {
        OrdenablePaginableContableCrudRepository<Product> repository = new ProductListRepository();

        repository.save(new Product("Logitech Keyboard", 120.0));
        repository.save(new Product("Chicken Breast", 15.1));
        repository.save(new Product("Samsung S26 Ultra", 1599.9));
        repository.save(new Product("MacBook Pro", 2199.9));

        List<Product> products = repository.listAll();
        products.forEach(System.out::println);

        System.out.println("===== paginable =====");
        List<Product> paginable = repository.listAll(0, 4);
        paginable.forEach(System.out::println);

        System.out.println("===== ordenable =====");
        List<Product> ordenable = repository.listAll("id", Direction.DESC);
        ordenable.forEach(System.out::println);

        System.out.println("===== update =====");
        Product orangeJuice = new Product("Orange Juice", 5.0);
        orangeJuice.setId(2);
        repository.update(orangeJuice);

        Product orange = repository.getById(2);
        System.out.println(orange);

        System.out.println("===== sort =====");
        repository.listAll("price", Direction.DESC).forEach(System.out::println);

        System.out.println("===== delete =====");
        repository.delete(2);
        repository.listAll().forEach(System.out::println);

        System.out.println("===== total =====");
        System.out.println("Total records: " + repository.total());
    }
}