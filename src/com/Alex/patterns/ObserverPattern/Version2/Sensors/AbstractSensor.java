package com.Alex.patterns.ObserverPattern.Version2.Sensors;

import com.Alex.patterns.ObserverPattern.Version2.Sensors.SensorStateChangers.StateChanger;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alex on 27.10.2015 027.
 */
public abstract class AbstractSensor implements Runnable {

    protected volatile int state = 0;
    protected String name;
    protected StateChanger sc;

    @Override
    public abstract void run();

    public synchronized int getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    protected void changeState(StateChanger sc) {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    state = sc.changeFunction(state);
                }
                TimeUnit.MILLISECONDS.sleep(sc.getDelay());
            }
        } catch (InterruptedException e) {
            System.out.println(name + " is Broken");
        }
    }
}
