package com.Alex.patterns.AdapterPattern;

/**
 * Created by Alex on 01.12.2015 001.
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble gobble.");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance.");

    }
}
