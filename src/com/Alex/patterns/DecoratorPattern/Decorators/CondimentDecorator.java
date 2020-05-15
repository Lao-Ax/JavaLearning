package com.Alex.patterns.DecoratorPattern.Decorators;

import com.Alex.patterns.DecoratorPattern.Beverage.Beverage;

/**
 * Created by Alex on 01.11.2015 001.
 */
public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;

    @Override
    public String getDescription() {
        return beverage.getDescription() + super.getDescription();
    }

    @Override
    public double cost() {
        return super.cost() + beverage.cost();
    }

    @Override
    public int getSize(){
        return beverage.getSize();
    }
}
