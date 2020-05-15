package com.Alex.patterns.AdapterPattern;

/**
 * Created by Alex on 01.12.2015 001.
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack!");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying.");
    }
}
