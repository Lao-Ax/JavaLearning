package com.Alex.patterns.DecoratorPattern.Decorators;

import com.Alex.patterns.DecoratorPattern.Beverage.Beverage;

/**
 * Created by Alex on 01.11.2015 001.
 */
public class Soy extends CondimentDecorator {
    @Override
    public double cost() {
        double cost = beverage.cost();
        if (getSize() == 0) cost += 0.1d;
        if (getSize() == 1) cost += 0.15d;
        if (getSize() == 2) cost += 0.2d;
        return cost;
    }

    public Soy(Beverage beverage) {
        this.beverage = beverage;
        setDescription(", Soy");
    }
}
