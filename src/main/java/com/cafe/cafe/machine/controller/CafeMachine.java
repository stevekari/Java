package com.cafe.cafe.machine.controller;

import com.cafe.cafe.machine.model.CoffeeType;
import com.cafe.cafe.machine.model.Ingredients;

public class CafeMachine {
    Ingredients ingredients;

    public CafeMachine(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public String makeCoffee(CoffeeType coffee) {
        System.out.println(coffee.message());
        System.out.println("Total: " + coffee.totalAmount());
        return "";

    }

}
