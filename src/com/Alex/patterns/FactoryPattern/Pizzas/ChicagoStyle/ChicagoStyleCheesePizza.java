package com.Alex.patterns.FactoryPattern.Pizzas.ChicagoStyle;

import com.Alex.patterns.FactoryPattern.Pizzas.CheesePizza;
import com.Alex.patterns.FactoryPattern.Pizzas.Ingredients.ChicagoPizzaIngredientFactory;

/**
 * Created by Alex on 04.11.2015 004.
 */
public class ChicagoStyleCheesePizza extends CheesePizza {
    public ChicagoStyleCheesePizza() {
        super(new ChicagoPizzaIngredientFactory());
        name = "Chicago Style Deep Dish Cheese Pizza";

        toppings.add("Shredded Mozzarella Cheese");
    }

    @Override
    public void cut() {
        System.out.println("Cutting the pizza into square slices");

    }
}
