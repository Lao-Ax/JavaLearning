package com.Alex.patterns.DecoratorPattern.Decorators;

import com.Alex.patterns.DecoratorPattern.Beverage.Beverage;

/**
 * Created by Alex on 01.11.2015 001.
 */
public class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {
        this.beverage = beverage;
        setDescription(", Whip");
        setCost(0.1d);
    }
}
