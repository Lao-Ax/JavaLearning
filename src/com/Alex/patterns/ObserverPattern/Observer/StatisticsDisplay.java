package com.Alex.patterns.ObserverPattern.Observer;

import com.Alex.patterns.ObserverPattern.Subject.Subject;
import com.Alex.patterns.ObserverPattern.Subject.WeatherData;

/**
 * Created by Alex on 28.10.2015 028.
 */
public class StatisticsDisplay implements Observer, DisplayElement {

    private int maxTemperature = -100;
    private float avgTemperature;
    private int minTemperature = 100;
    private Subject wd;
    private boolean hasChanged = false;

    public StatisticsDisplay(Subject wd) {
        this.wd = wd;
        wd.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.printf("Avg/Max/Min temperature = %.1f / %d / %d", avgTemperature, maxTemperature, minTemperature);
        System.out.println();
    }

    @Override
    public void update(int temperature, int humidity, int pressure) {
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
        display();
    }
}
