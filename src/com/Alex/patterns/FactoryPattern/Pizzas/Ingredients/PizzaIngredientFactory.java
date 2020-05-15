package com.Alex.patterns.FactoryPattern.Pizzas.Ingredients;

/**
 * Created by Alex on 05.11.2015 005.
 */
public interface PizzaIngredientFactory {

    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClam();
}
