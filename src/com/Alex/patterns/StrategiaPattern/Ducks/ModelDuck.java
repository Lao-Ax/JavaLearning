package com.Alex.patterns.StrategiaPattern.Ducks;

import com.Alex.patterns.StrategiaPattern.Flys.FlyNoWay;
import com.Alex.patterns.StrategiaPattern.Quacks.Quack;

/**
 * Created by Alex on 26.10.2015 026.
 */
public class ModelDuck extends Duck {

    public ModelDuck() {
        quckBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck.");
    }


}
