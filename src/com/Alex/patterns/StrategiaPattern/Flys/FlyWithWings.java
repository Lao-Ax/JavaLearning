package com.Alex.patterns.StrategiaPattern.Flys;

/**
 * Created by Alex on 26.10.2015 026.
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying!!");
    }
}
