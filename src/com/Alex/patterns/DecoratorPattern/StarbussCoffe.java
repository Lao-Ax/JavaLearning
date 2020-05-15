package com.Alex.patterns.DecoratorPattern;

import com.Alex.patterns.DecoratorPattern.Beverage.Beverage;
import com.Alex.patterns.DecoratorPattern.Beverage.HouseBlend;
import com.Alex.patterns.DecoratorPattern.Decorators.Mocha;
import com.Alex.patterns.DecoratorPattern.Decorators.Soy;
import com.Alex.patterns.DecoratorPattern.Decorators.Whip;

/**
 * Created by Alex on 01.11.2015 001.
 */
public class StarbussCoffe {
    public static void main(String[] args){
//        Beverage beverage = new Espresso();
//        System.out.println(beverage.getDescription() + " $" + beverage.cost());
//
//        Beverage beverage2 = new DarkRoast();
//        beverage2 = new Whip(new Mocha(new Mocha(beverage2)));
//        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Whip(new Mocha(new Soy(beverage3)));
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());

    }
}
