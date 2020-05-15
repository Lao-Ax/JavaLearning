package com.Alex.patterns.ObserverPattern.Sensors.SensorStateChangers;

/**
 * Created by Alex on 27.10.2015 027.
 */
public class HumidityChanger implements StateChanger {
    @Override
    public int getDelay() {
        return 200;
    }

    @Override
    public int changeFunction(int state) {
        return (state + 3) % 100;
    }
}
