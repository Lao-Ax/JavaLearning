package com.Alex.patterns.StrategiaPattern.Quacks;

/**
 * Created by Alex on 26.10.2015 026.
 */
public class Squeak implements QuckBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak!");
    }
}
