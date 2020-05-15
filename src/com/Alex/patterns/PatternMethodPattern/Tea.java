package com.Alex.patterns.PatternMethodPattern;

/**
 * Created by Alex on 23.12.2015 023.
 */
public class Tea extends CaffeineBevarage {
    @Override
    void brew() {
        System.out.println("Steeping the tea.");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding a lemon.");
    }
}
