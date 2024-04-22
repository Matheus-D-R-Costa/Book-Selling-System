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

    @Override
    public double calculateShipping() {
        return (getPrice() * getQuantity()) * (1 + gender.getFactor());
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", id=" + getId() +
                ", price=" + getPrice() +
                '}';
    }
}
