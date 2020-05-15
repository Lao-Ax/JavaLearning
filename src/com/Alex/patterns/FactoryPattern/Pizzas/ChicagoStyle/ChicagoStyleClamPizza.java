package com.Alex.patterns.FactoryPattern.Pizzas.ChicagoStyle;

import com.Alex.patterns.FactoryPattern.Pizzas.ClamPizza;
import com.Alex.patterns.FactoryPattern.Pizzas.Ingredients.ChicagoPizzaIngredientFactory;

/**
 * Created by Alex on 04.11.2015 004.
 */
public class ChicagoStyleClamPizza extends ClamPizza {

    public ChicagoStyleClamPizza() {
        super(new ChicagoPizzaIngredientFactory());
        name = "Chicago Clam Pizza Best!";
    }

    @Override
    public void prepare() {

    }

    @Override
    public void bake() {

    }

    @Override
    public void cut() {

    }

    @Override
    public void box() {

    }
}
