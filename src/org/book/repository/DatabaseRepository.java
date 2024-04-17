package org.book.repository;

import org.book.model.Client;
import org.book.model.Coupon;
import org.book.model.Order;
import org.book.model.Product;

import java.util.ArrayList;
import java.util.List;

public class DatabaseRepository {

    private Client client;
    private List<Product> products;
    private  List<Order> orders;
    private List<Coupon> coupons;

    public Client getClient() {
        return client;
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

    public DatabaseRepository() {
        this.client = new Client();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();

        this.coupons = new ArrayList<>();
        coupons.add(new Coupon("COUPON2", 2));
        coupons.add(new Coupon("COUPON5", 5));
        coupons.add(new Coupon("COUPON10", 10));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int position) {
        products.remove(position);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removerOrder(int position) {
        orders.remove(position);
    }
}
