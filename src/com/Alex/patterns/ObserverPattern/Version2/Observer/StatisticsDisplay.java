package com.Alex.patterns.ObserverPattern.Version2.Observer;

import com.Alex.patterns.ObserverPattern.Version2.Subject.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Alex on 28.10.2015 028.
 */
public class StatisticsDisplay implements Observer, DisplayElement {

    private int maxTemperature = -100;
    private float avgTemperature;
    private int minTemperature = 100;
    private Observable observable;
    private boolean hasChanged = false;

    public StatisticsDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.printf("Avg/Max/Min temperature = %.1f / %d / %d", avgTemperature, maxTemperature, minTemperature);
        System.out.println();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData wd = (WeatherData) o;
            int temperature = wd.getTemperature();
            if (temperature > maxTemperature) {
                maxTemperature = temperature;
                hasChanged = true;
            }
            if (temperature < minTemperature) {
                minTemperature = temperature;
                hasChanged = true;
            }
            if (hasChanged) {
                avgTemperature = (maxTemperature + minTemperature) / 2;
                hasChanged = false;
            }
        }
        display();
    }
}
