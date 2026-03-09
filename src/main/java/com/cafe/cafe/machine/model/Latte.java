package com.cafe.cafe.machine.model;

public class Latte implements CoffeeType {
    String size;

    public Latte(String size) {
        this.size = size;
    }

    @Override
    public double totalAmount() {
        return size.equals("long ") ? 2.50 : 1.80;
    }

    @Override
    public String message() {
        return "Your " + size + "latte is ready";
    }

    @Override
    public double amount() {
        return totalAmount();
    }

}
