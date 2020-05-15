package com.Alex.patterns.StrategiaPattern;

import com.Alex.patterns.StrategiaPattern.Ducks.Duck;
import com.Alex.patterns.StrategiaPattern.Ducks.MallardDuck;
import com.Alex.patterns.StrategiaPattern.Ducks.ModelDuck;
import com.Alex.patterns.StrategiaPattern.Flys.FlyRocketPowered;

/**
 * Created by Alex on 26.10.2015 026.
 */
public class MiniDuckSimulator {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();

        mallard.performFly();
        mallard.performQuack();

        Duck model = new ModelDuck();
        model.display();

        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
