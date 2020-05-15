package com.Alex.patterns.ObserverPattern.Sensors;

import com.Alex.patterns.ObserverPattern.Sensors.SensorStateChangers.TemperatureChanger;

/**
 * Created by Alex on 27.10.2015 027.
 */
public class TemperatureSensor extends AbstractSensor {

    public TemperatureSensor() {
        name = "Temperature Sensor";
        state = 18;
        sc = new TemperatureChanger();
    }

    public TemperatureSensor(String name, int state) {
        this.name = name;
        this.state = state;
        sc = new TemperatureChanger();
    }

    @Override
    public void run() {
        changeState(sc);
    }
}
