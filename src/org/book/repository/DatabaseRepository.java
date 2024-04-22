package org.book.repository;

import org.book.model.Client;
import org.book.model.Coupon;
import org.book.model.Order;
import org.book.model.Product;

import java.util.ArrayList;
import java.util.List;

public class DatabaseRepository {


    private Client client;
    private List<Client> clients;
    private List<Product> products;
    private  List<Order> orders;
    private List<Coupon> coupons;

    public DatabaseRepository() {
        this.client = new Client();

        this.clients = new ArrayList<>();
        clients.add(client);

        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();

        this.coupons = new ArrayList<>();
        coupons.add(new Coupon("COUPON2", 2));
        coupons.add(new Coupon("COUPON5", 5));
        coupons.add(new Coupon("COUPON10", 10));
    }

    public Client getClient() {
        return client;
    }

    public Client[] getClients() {
        return clients.toArray(new Client[clients.size()]);
    }

    public Product[] getProducts() {
        return products.toArray(new Product[products.size()]);
    }

    public Order[] getOrders() {
        return orders.toArray(new Order[orders.size()]);
    }

    public Coupon[] getCoupons() {
        return coupons.toArray(new Coupon[coupons.size()]);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removerOrder(Order order) {
        orders.remove(order);
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }
}
