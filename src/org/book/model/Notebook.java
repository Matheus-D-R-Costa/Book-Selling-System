package org.book.model;

import org.book.model.enums.Material;

public class Notebook extends Product {

    private Material type;

    public Material getType() {
        return type;
    }

    public void setType(Material type) {
        this.type = type;
    }

    @Override
    public double calculateShipping() {
        return (getPrice() * getQuantity()) + type.getFactor();
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "type='" + type + '\'' +
                ", id=" + getId() +
                ", price=" + getPrice() +
                '}';
    }
}
