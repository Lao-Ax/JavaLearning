package com.Alex.patterns.ObserverPattern.Version2.Sensors;

import com.Alex.patterns.ObserverPattern.Version2.Sensors.SensorStateChangers.HumidityChanger;

/**
 * Created by Alex on 27.10.2015 027.
 */
public class HumiditySensor extends AbstractSensor {

    public HumiditySensor() {
        name = "Humidity Sensor";
        state = 21;
        sc = new HumidityChanger();
    }

    @Override
    public void run() {
        changeState(sc);
    }
}
