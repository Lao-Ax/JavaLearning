package com.Alex.patterns.FactoryPattern.Pizzas;

import com.Alex.patterns.FactoryPattern.Pizzas.Ingredients.PizzaIngredientFactory;

/**
 * Created by Alex on 05.11.2015 005.
 */
public class ClamPizza extends Pizza {
    PizzaIngredientFactory pizzaIngredientFactory;

    public ClamPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparin " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
        clams = pizzaIngredientFactory.createClam();

    }
}
