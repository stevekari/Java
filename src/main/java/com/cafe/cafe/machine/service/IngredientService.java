package com.cafe.cafe.machine.service;

import com.cafe.cafe.machine.model.Ingredients;

public class IngredientService {
    private Ingredients ingredients = new Ingredients(1000, 500, 500);

    public Ingredients getStatus() {
        return ingredients;
    }

    public void use(int water, int beans, int milk) {
        ingredients.setWater(ingredients.getWater() - water);
        ingredients.setMilk(ingredients.getMilk() - milk);
        ingredients.setCoffeeBeans(ingredients.getCoffeeBeans() - beans);
    }

    public void refill() {
        ingredients = new Ingredients(1000, 500, 500);
    }

    public void autoRefill() {
        if (ingredients.getWater() < 100 || ingredients.getCoffeeBeans() < 50 || ingredients.getMilk() < 500) {
            refill();
        }
    }
}
