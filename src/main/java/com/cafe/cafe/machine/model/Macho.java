package com.cafe.cafe.machine.model;

public class Macho implements CoffeeType {
    String size;

    public Macho(String size) {
        this.size = size;
    }

    @Override
    public double totalAmount() {
        return size.equals("long ") ? 2.50 : 1.80;
    }

    @Override
    public String message() {
        return "Your " + size + "Macho is ready";
    }

    @Override
    public double amount() {
        return totalAmount();
    }

}
