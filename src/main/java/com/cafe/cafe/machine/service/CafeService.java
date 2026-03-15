package com.cafe.cafe.machine.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cafe.cafe.machine.model.Americano;
import com.cafe.cafe.machine.model.Cappuccino;
import com.cafe.cafe.machine.model.CoffeeType;
import com.cafe.cafe.machine.model.Espresso;
import com.cafe.cafe.machine.model.Latte;
import com.cafe.cafe.machine.model.Macchiato;
import com.cafe.cafe.machine.model.Macho;

@Service
public class CafeService {

    public Map<String, Object> prepareCoffeeJson(
            String type, String size) {
        CoffeeType coffee = createCoffee(type, size);

        Map<String, Object> response = new HashMap<>();
        response.put("message", coffee.message());
        response.put("total", coffee.totalAmount());
        response.put("size", size);
        response.put("type", type);

        return response;
    }

    public String prepareCoffeeText(String type, String size) {
        CoffeeType coffee = createCoffee(type, size);
        return coffee.message() + "| Total" + coffee.totalAmount();
    }

    // private CoffeeType createCoffee(String type, String size) {
    // CoffeeCategory category = CoffeeCategory.fromString(type);

    // return switch (category) {
    // case ESPRESSO -> new Espresso(size);
    // case CAPPUCCINO -> new Cappuccino(size);
    // case AMERICANO -> new Americano(size);
    // case AMERICANO -> new Americano(size);
    // case AMERICANO -> new Americano(size);
    // default -> throw new IllegalArgumentException("Unexpected value: " +
    // category);
    // };
    // }

    private CoffeeType createCoffee(String type, String size) {

        if (type == null)
            throw new IllegalArgumentException("Type cannot be null");

        switch (type.toLowerCase().trim()) {
            case "espresso" -> {
                return new Espresso(size);
            }

            case "cappuccino" -> {
                // Fixed spelling from "cuppoccino"
                return new Cappuccino(size);
            }

            case "americano" -> {
                return new Americano(size);
            }

            case "latte" -> {
                return new Latte(size);
            }

            case "macho" -> {
                return new Macho(size);
            }

            case "macchiato" -> {
                return new Macchiato(size);
            }

            default -> throw new IllegalArgumentException("Unknown coffee type: " + type);
        }
    }

    // private CoffeeType createCoffee(String type, String size) {
    // switch (type) {
    // case "espresso":
    // return new Espresso(size);

    // case "cappuccino":
    // return new Cappuccino(size);

    // case "americano":
    // return new Americano(size);
    // case "latte":
    // return new Latte(size);

    // default:
    // throw new IllegalArgumentException("Unknown coffee type");
    // }
    // }

}
