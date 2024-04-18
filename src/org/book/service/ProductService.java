package org.book.service;

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

        int productDeletion = -1;
        for (int i = 0; i < database.getProducts().length; i++) {

            Product product = database.getProducts()[i];
            if (product.getId().equals(id)) {
                productDeletion = i;
                break;
            }
        }

        if (productDeletion != -1) {
            database.removeProduct(productDeletion);
            System.out.println("Produto excluido com sucesso.");
        } else {
            System.out.println("Produto inexistente.");
        }
    }

    public Optional<Product> consult(String id) {

        for (Product product : database.getProducts()) {

            if (product.getId().equalsIgnoreCase(id)) {
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
