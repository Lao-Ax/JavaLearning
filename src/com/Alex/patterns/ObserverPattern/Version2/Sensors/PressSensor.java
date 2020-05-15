package com.Alex.patterns.ObserverPattern.Version2.Sensors;

import com.Alex.patterns.ObserverPattern.Version2.Sensors.SensorStateChangers.PressChanger;

/**
 * Created by Alex on 27.10.2015 027.
 */
public class PressSensor extends AbstractSensor {

    public PressSensor() {
        name = "Press Sensor";
        state = 8;
        sc = new PressChanger();
    }

    @Override
    public void run() {
        changeState(sc);
    }
}
