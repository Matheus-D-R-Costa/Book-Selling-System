package org.book.service;

import org.book.model.Coupon;
import org.book.model.Order;
import org.book.model.Product;
import org.book.repository.DatabaseRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class OrderService {

    private DatabaseRepository database;

    public OrderService(DatabaseRepository database) {
        this.database = database;
    }

    private double calculateTotal(List<Product> products, Coupon coupon) {
        double total = 0.0;

        for (Product product : products) {
            total += product.calculateShipping(); //TODO fazer método calculateShipping
        }

        if (coupon != null) {
            return total + (1 - coupon.getDiscount());
        } else {
            return total;
        }
    }

    public void save(Order newOrder) {
        save(newOrder, null);
    }

    public void save(Order newOrder, Coupon coupon) {

        String id = "OR%4d%2d%04d";
        LocalDate today = LocalDate.now();
        id = String.format(id, today.getYear(), today.getMonthValue(), database.getOrders().length);

        newOrder.setId(id);
        newOrder.setClient(database.getClient());
        newOrder.setTotal(calculateTotal(newOrder.getProducts(), coupon));
        database.addOrder(newOrder);
        System.out.println("Pedido cadastrado com sucesso.");

    }

    public void delete(String id) {

        Optional<Order> orderToRemove = consult(id);

        if (orderToRemove.isPresent()) {
            Order order = orderToRemove.get();
            database.removerOrder(order);
            System.out.println("Pedido removido com sucesso.");;
        } else {
            System.out.println("Pedido inexistente.");
        }
    }

    public Optional<Order> consult(String id) {

        for(Order order : database.getOrders()) {

            if(order.getId().equalsIgnoreCase(id)) {
                System.out.println(order);
                return Optional.of(order);
            }
        }

        return Optional.empty();

    }

    public void showAll() {

        if(database.getOrders().length == 0) {
            System.out.println("Não há pedidos cadastrados.");
        } else {

            for(Order order : database.getOrders()) {
                System.out.println(order.toString());
            }
        }
    }
}
