package com.Alex.patterns.FacadePattern.Devices;

/**
 * Created by Alex on 04.12.2015 004.
 */
public class TheaterLights {

    public void on(){
        System.out.println("Lights is on.");
    }

    public void off(){
        System.out.println("Lights is off.");
    }

    public void dim(int i){
        System.out.println("Dimming the lights on " + i);
    }
}
