package com.Alex.patterns.StrategiaPattern.Ducks;

import com.Alex.patterns.StrategiaPattern.Flys.FlyBehavior;
import com.Alex.patterns.StrategiaPattern.Quacks.QuckBehavior;

/**
 * Created by Alex on 26.10.2015 026.
 */
public abstract class Duck {

    protected FlyBehavior flyBehavior;
    protected QuckBehavior quckBehavior;

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quckBehavior.quack();
    }

    public void swim(){
        System.out.println("All ducks float, even decoys!");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuckBehavior(QuckBehavior quckBehavior) {
        this.quckBehavior = quckBehavior;
    }

    public QuckBehavior getQuckBehavior() {
        return quckBehavior;
    }

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }
}
