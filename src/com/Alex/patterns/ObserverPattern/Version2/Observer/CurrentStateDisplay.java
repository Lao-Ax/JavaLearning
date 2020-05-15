package com.Alex.patterns.ObserverPattern.Version2.Observer;

import com.Alex.patterns.ObserverPattern.Version2.Subject.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Alex on 28.10.2015 028.
 */
public class CurrentStateDisplay implements Observer, DisplayElement {

    private int temperature;
    private int humidity;
    private Observable observable;

    public CurrentStateDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "C degrees and " + humidity + "% humigity.");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData wd = (WeatherData) o;
            temperature = wd.getTemperature();
            humidity = wd.getHumidity();
        }
        display();
    }
}
