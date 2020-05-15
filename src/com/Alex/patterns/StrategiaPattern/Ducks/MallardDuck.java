package com.Alex.patterns.StrategiaPattern.Ducks;

import com.Alex.patterns.StrategiaPattern.Flys.FlyWithWings;
import com.Alex.patterns.StrategiaPattern.Quacks.Quack;

/**
 * Created by Alex on 26.10.2015 026.
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        quckBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck.");
    }
}
