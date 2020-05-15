package com.Alex.patterns.FactoryPattern.Pizzas;

import com.Alex.patterns.FactoryPattern.Pizzas.Ingredients.PizzaIngredientFactory;

/**
 * Created by Alex on 05.11.2015 005.
 */
public class CheesePizza extends Pizza {
    PizzaIngredientFactory pizzaIngredientFactory;

    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
    }


}
