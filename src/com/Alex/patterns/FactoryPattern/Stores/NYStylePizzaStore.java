package com.Alex.patterns.FactoryPattern.Stores;

import com.Alex.patterns.FactoryPattern.Pizzas.Ingredients.NYPizzaIngredientFactory;
import com.Alex.patterns.FactoryPattern.Pizzas.Ingredients.PizzaIngredientFactory;
import com.Alex.patterns.FactoryPattern.Pizzas.NYStyle.NYStyleCheesePizza;
import com.Alex.patterns.FactoryPattern.Pizzas.NYStyle.NYStyleClamPizza;
import com.Alex.patterns.FactoryPattern.Pizzas.NYStyle.NYStylePepperoniPizza;
import com.Alex.patterns.FactoryPattern.Pizzas.NYStyle.NYStyleVeggiePizza;
import com.Alex.patterns.FactoryPattern.Pizzas.Pizza;

/**
 * Created by Alex on 04.11.2015 004.
 */
public class NYStylePizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();
            Pizza pizza = new NYStyleCheesePizza(pizzaIngredientFactory);
            pizza.setName("New York Style Cheese Pizza");
            return pizza;
        } else if (type.equals("veggie")) {
            return new NYStyleVeggiePizza();
        } else if (type.equals("clam")) {
            return new NYStyleClamPizza();
        } else if (type.equals("pepperoni")) {
            return new NYStylePepperoniPizza();
        } else return null;
    }
}
