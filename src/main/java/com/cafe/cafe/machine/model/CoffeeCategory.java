package com.cafe.cafe.machine.model;

public enum CoffeeCategory {
    ESPRESSO, CAPPUCCINO, AMERICANO, MACHO, MACCHIATO, CORTADO;

    public static CoffeeCategory fromString(String value) {
        try {
            return CoffeeCategory.valueOf(value.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("We don't serve " + value);
        }
    }
}