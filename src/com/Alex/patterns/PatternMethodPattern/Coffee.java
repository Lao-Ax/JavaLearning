package com.Alex.patterns.PatternMethodPattern;

/**
 * Created by Alex on 23.12.2015 023.
 */
public class Coffee extends CaffeineBevarage {
    @Override
    void brew() {
        System.out.println("Dripping coffee through filter.");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding a sugar and milk.");
    }
}