package org.book.model;

public class Coupon {

    private final String id;
    private final double discount;


    public String getId() {
        return id;
    }

    public double getDiscount() {
        return discount;
    }

    public Coupon(String id, double discount) {
        this.id = id;
        this.discount = discount;
    }
}
