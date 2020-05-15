package com.Alex.patterns.DecoratorPattern.Beverage;

/**
 * Created by Alex on 01.11.2015 001.
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        setDescription("House Blend Coffee");
        setCost(0.89d);
        setSize(0);
    }

    public HouseBlend(int size) {
        setDescription("House Blend Coffee " + size);
        setCost(0.89d);
        setSize(size);
    }
}
