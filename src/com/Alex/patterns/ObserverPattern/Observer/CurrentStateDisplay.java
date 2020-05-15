package com.Alex.patterns.ObserverPattern.Observer;

import com.Alex.patterns.ObserverPattern.Subject.Subject;
import com.Alex.patterns.ObserverPattern.Subject.WeatherData;

/**
 * Created by Alex on 28.10.2015 028.
 */
public class CurrentStateDisplay implements Observer, DisplayElement {

    private int temperature;
    private int humidity;
    private Subject wd;

    public CurrentStateDisplay(Subject wd) {
        this.wd = wd;
        this.wd.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "C degrees and " + humidity + "% humigity.");
    }

    @Override
    public void update(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
}
