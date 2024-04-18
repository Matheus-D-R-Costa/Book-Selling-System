package org.book.model.enums;

public enum Gender {

    DRAMA(15),
    SUSPENSE(10),
    ROMANCE(5);

    private final double factor;

    Gender(double factor) {
        this.factor = factor / 100;
    }

    public double getFactor() {
        return factor;
    }
}
