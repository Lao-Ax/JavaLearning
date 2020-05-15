package com.Alex.patterns.ObserverPattern.Version2.Sensors;

import com.Alex.patterns.ObserverPattern.Version2.Sensors.SensorStateChangers.TemperatureChager;

/**
 * Created by Alex on 27.10.2015 027.
 */
public class TemperatureSensor extends AbstractSensor {

    public TemperatureSensor() {
        name = "Temperature Sensor";
        state = 18;
        sc = new TemperatureChager();
    }

    @Override
    public void run() {
        changeState(sc);
    }
}
