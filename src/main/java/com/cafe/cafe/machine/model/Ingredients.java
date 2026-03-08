package com.cafe.cafe.machine.model;

public class Ingredients {
    double water;
    double coffeeBeans;
    double milk;

    public Ingredients(double water, double coffeeBeans, double milk) {
        this.water = water;
        this.coffeeBeans = coffeeBeans;
        this.milk = milk;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public double getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(double coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public double getMilk() {
        return milk;
    }

    public void setMilk(double milk) {
        this.milk = milk;
    }

}
