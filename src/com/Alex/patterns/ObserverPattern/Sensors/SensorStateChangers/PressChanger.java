package com.Alex.patterns.ObserverPattern.Sensors.SensorStateChangers;

/**
 * Created by Alex on 27.10.2015 027.
 */
public class PressChanger implements StateChanger {
    @Override
    public int getDelay() {
        return 300;
    }

    @Override
    public int changeFunction(int state) {
        return state < 8 ? 8 : ++state % 40;
    }
}
