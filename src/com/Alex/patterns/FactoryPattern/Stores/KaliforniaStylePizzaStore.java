package com.Alex.patterns.FactoryPattern.Stores;

import com.Alex.patterns.FactoryPattern.Pizzas.KaliforniaStyle.*;
import com.Alex.patterns.FactoryPattern.Pizzas.Pizza;

/**
 * Created by Alex on 04.11.2015 004.
 */
public class KaliforniaStylePizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new KaliforniaStyleCheesePizza();
        } else if (type.equals("veggie")) {
            return new KaliforniaStyleVeggiePizza();
        } else if (type.equals("clam")) {
            return new KaliforniaStyleClamPizza();
        } else if (type.equals("pepperoni")) {
            return new KaliforniaStylePepperoniPizza();
        } else return null;
    }
}
