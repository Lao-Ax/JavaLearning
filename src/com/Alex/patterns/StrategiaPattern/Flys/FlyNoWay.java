package com.Alex.patterns.StrategiaPattern.Flys;

/**
 * Created by Alex on 26.10.2015 026.
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly.");
    }
}
