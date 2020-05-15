package com.Alex.patterns.FactoryPattern.Stores;

import com.Alex.patterns.FactoryPattern.Pizzas.Pizza;

/**
 * Created by Alex on 04.11.2015 004.
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type){
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    abstract Pizza createPizza(String type);
}
