package com.Alex.patterns.ObserverPattern.Version2.Subject;

import com.Alex.patterns.ObserverPattern.Version2.Sensors.AbstractSensor;

import java.util.Observable;

/**
 * Created by Alex on 28.10.2015 028.
 */
public class WeatherData extends Observable {
    private AbstractSensor tempSensor, humSensor, pressSensor;

    public WeatherData(AbstractSensor tempSensor, AbstractSensor humSensor, AbstractSensor pressSensor) {
        this.tempSensor = tempSensor;
        this.humSensor = humSensor;
        this.pressSensor = pressSensor;
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public int getTemperature() {
        return tempSensor.getState();
    }

    public int getHumidity(){
        return humSensor.getState();
    }

    public int getPressure() {
        return pressSensor.getState();
    }
}
