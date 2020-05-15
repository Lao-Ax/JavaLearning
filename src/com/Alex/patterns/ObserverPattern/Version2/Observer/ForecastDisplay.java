package com.Alex.patterns.ObserverPattern.Version2.Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Alex on 28.10.2015 028.
 */
public class ForecastDisplay implements Observer, DisplayElement {
    private final String[] forecasts = {
            "Improving weather on the way!",
            "Watch out for cooler, rainy weather.",
            "More of the same."};

    private Observable observable;

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println(forecasts[(int)(Math.random()*3)]);
    }

    @Override
    public void update(Observable o, Object arg) {
        display();
    }
}
