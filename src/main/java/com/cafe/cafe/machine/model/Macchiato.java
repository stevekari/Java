package com.cafe.cafe.machine.model;

public class Macchiato implements CoffeeType {
    String size;

    public Macchiato(String size) {
        this.size = size;
    }

    @Override
    public double totalAmount() {
        return size.equals("long ") ? 2.50 : 1.80;
    }

    @Override
    public String message() {
        return "Your " + size + "Macchiato is ready";
    }

    @Override
    public double amount() {
        return totalAmount();
    }

}
