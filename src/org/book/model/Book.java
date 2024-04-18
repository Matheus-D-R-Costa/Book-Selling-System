package org.book.model;

import org.book.model.enums.Gender;

public class Book extends Product{

    private String name;
    private Gender gender;

    public Book() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double calculateShipping() {
        return (getPrice() * getQuantity()) * (1 + gender.getFactor());
    }
}
