package org.book.service;

import org.book.model.Order;
import org.book.model.Product;
import org.book.repository.DatabaseRepository;

import java.util.Optional;

public class ProductService {

    private DatabaseRepository database;

    public ProductService(DatabaseRepository database) {
        this.database = database;
    }

    public void save(Product newProduct) {

        String id = "PR%04d";
        id = String.format(id, database.getProducts().length);

        boolean repeatProduct = false;
        for (Product product : database.getProducts()) {
            if (product.getId() == newProduct.getId()) {
                repeatProduct = true;
                System.out.println("Produto já cadastrado.");
                break;
            }
        }

        if (!repeatProduct) {
            this.database.addProduct(newProduct);
            System.out.println("Produto cadastrado com sucesso.");
        }
    }

    public void delete(String id) {

        Optional<Product> productToRemove = consult(id);

        if (productToRemove.isPresent()) {
            Product product = productToRemove.get();
            database.removeProduct(product);
            System.out.println("Pedido removido com sucesso.");;
        } else {
            System.out.println("Pedido inexistente.");
        }
    }

    public Optional<Product> consult(String id) {

        for (Product product : database.getProducts()) {

            if (product.getId().equalsIgnoreCase(id)) {
                System.out.println(product);
                return Optional.of(product);
            }
        }

        return Optional.empty();

    }

    public void showAll() {

        if (database.getProducts().length == 0) {
            System.out.println("Não existem produtos cadastrados");
        } else {

            for (Product product : database.getProducts()) {
                System.out.println(product.toString());
            }
        }
    }
}
