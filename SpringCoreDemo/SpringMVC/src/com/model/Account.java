package com.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

public class Account {

    @Min(value=100)
    private int id;
    @NotEmpty
    private String name;

    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account() {

    }

    private double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
