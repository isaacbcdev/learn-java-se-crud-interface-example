package org.isaacbcdev.oppinterface.repository.list;

import org.isaacbcdev.oppinterface.model.Product;
import org.isaacbcdev.oppinterface.repository.AbstractListRepository;
import org.isaacbcdev.oppinterface.repository.Direction;

import java.util.ArrayList;
import java.util.List;

public class ProductListRepository extends AbstractListRepository<Product> {

    @Override
    public void update(Product product) {
        Product p = getById(product.getId());
        p.setName(product.getName());
        p.setPrice(product.getPrice());
    }

    @Override
    public List<Product> listAll(String field, Direction dir) {
        List<Product> ordenable = new ArrayList<>(this.dataSource);
        ordenable.sort((Product a, Product b) -> {
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

    public static int sort(String field, Product a, Product b) {
        int result = 0;

        switch (field) {
            case "id" -> result = a.getId().compareTo(b.getId());
            case "name" -> result = a.getName().compareTo(b.getName());
            case "price" -> result = a.getPrice().compareTo(b.getPrice());
        }

        return result;
    }
}