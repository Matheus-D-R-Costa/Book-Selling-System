package org.book.model.enums;

public enum Material {

    M2(2),
    M5(5),
    M10(10);

    private final double factor;

    Material(double factor) {
        this.factor = factor / 100;
    }

    public double getFactor() {
        return factor;
    }
}
