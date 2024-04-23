package org.book.model;

public class Client {

    private String name;
    private String cpf;

    public Client() {
        this.name = "Kylian";
        this.cpf = "123456789";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
