package com.Alex.patterns.DecoratorPattern.Decorators;

import com.Alex.patterns.DecoratorPattern.Beverage.Beverage;

/**
 * Created by Alex on 01.11.2015 001.
 */
public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
        setDescription(", Mocha");
        setCost(0.20d);
    }
}
