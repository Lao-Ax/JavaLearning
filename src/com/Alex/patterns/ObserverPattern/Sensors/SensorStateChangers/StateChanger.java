package com.Alex.patterns.ObserverPattern.Sensors.SensorStateChangers;

/**
 * Created by Alex on 27.10.2015 027.
 */
public interface StateChanger {
    int getDelay();
    int changeFunction(int state);
}
