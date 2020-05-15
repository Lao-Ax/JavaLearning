package com.Alex.patterns.FactoryPattern.Pizzas.NYStyle;

import com.Alex.patterns.FactoryPattern.Pizzas.CheesePizza;
import com.Alex.patterns.FactoryPattern.Pizzas.Ingredients.PizzaIngredientFactory;

/**
 * Created by Alex on 04.11.2015 004.
 */
public class NYStyleCheesePizza extends CheesePizza {

    public NYStyleCheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        super(pizzaIngredientFactory);
        name = "Chicago Style Deep Dish Cheese Pizza";

        toppings.add("Shredded Mozzarella Cheese");

        toppings.add("Grated Reggiano Cheese");
    }
}
