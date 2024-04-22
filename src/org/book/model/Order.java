package org.book.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String id;
    private Client client = new Client();
    private List<Product> products = new ArrayList<Product>();
    private double total;

    public Order() {
        this.products = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", client=" + client +
                ", products=" + getPurchasedProducts() +
                ", total=" + total +
                '}';
    }

    private String getPurchasedProducts() {

        StringBuilder products = new StringBuilder();
        products.append("[");
        for (Product product : getProducts()) {
            products.append(product.toString());
            products.append("Qtd:");
            products.append(product.getQuantity());
            products.append(" ");
        }
        products.append("]");

        return products.toString();
    }

}
