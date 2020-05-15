package com.Alex.patterns.ObserverPattern.Observer;

import com.Alex.patterns.ObserverPattern.Subject.WeatherData;

/**
 * Created by Alex on 28.10.2015 028.
 */
public class ForecastDisplay implements Observer, DisplayElement {
    private static final String[] FORECASTS = {
            "Improving weather on the way!",
            "Watch out for cooler, rainy weather.",
            "More of the same."};

    private WeatherData wd;

    public ForecastDisplay(WeatherData wd) {
        this.wd = wd;
        this.wd.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println(FORECASTS[(int)(Math.random()*3)]);
    }

    @Override
    public void update(int temp, int humidity, int pressure) {
        display();
    }
}
