package com.Alex.patterns.FactoryPattern.Stores;

import com.Alex.patterns.FactoryPattern.Pizzas.ChicagoStyle.*;
import com.Alex.patterns.FactoryPattern.Pizzas.Pizza;

/**
 * Created by Alex on 04.11.2015 004.
 */
public class ChicagoStylePizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("veggie")) {
            return new ChicagoStyleVeggiePizza();
        } else if (type.equals("clam")) {
            return new ChicagoStyleClamPizza();
        } else if (type.equals("pepperoni")) {
            return new ChicagoStylePepperoniPizza();
        } else return null;
    }
}
