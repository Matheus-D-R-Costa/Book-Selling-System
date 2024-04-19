package org.book.service;

import org.book.model.Coupon;
import org.book.model.Order;
import org.book.model.Product;
import org.book.repository.DatabaseRepository;

import java.util.List;

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
        //TODO método save
    }

    public void delete(String id) {
        int deleteOrder = -1;

        for (int i = 0; i < database.getOrders().length; i++) {

            Order order = database.getOrders()[i];

            if (order.getId().equals(id)) {
                deleteOrder = i;
                break;
            }
        }

        if (deleteOrder != -1) {
            database.removerOrder(deleteOrder);
            System.out.println("Pedido excluído com sucesso.");
        } else {
            System.out.println("Pedido inexistente.");
        }
    }

    //TODO método de listar todos os pedidos
}
