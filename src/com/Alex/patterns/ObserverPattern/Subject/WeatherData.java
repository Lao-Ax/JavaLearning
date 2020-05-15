package com.Alex.patterns.ObserverPattern.Subject;

import com.Alex.patterns.ObserverPattern.Observer.Observer;
import com.Alex.patterns.ObserverPattern.Sensors.AbstractSensor;

import java.util.ArrayList;

/**
 * Created by Alex on 28.10.2015 028.
 */
public class WeatherData implements Subject {
    private AbstractSensor tempSensor, humSensor, pressSensor;
    private ArrayList<Observer> observers = new ArrayList();

    public WeatherData(AbstractSensor tempSensor, AbstractSensor humSensor, AbstractSensor pressSensor) {
        this.tempSensor = tempSensor;
        this.humSensor = humSensor;
        this.pressSensor = pressSensor;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) observers.remove(i);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(getTemperature(), getHumidity(), getPressure());
        }
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

    public void measurementsChanged() {
        notifyObservers();
    }
}
