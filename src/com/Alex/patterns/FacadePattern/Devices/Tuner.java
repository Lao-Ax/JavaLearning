package com.Alex.patterns.FacadePattern.Devices;

/**
 * Created by Alex on 03.12.2015 003.
 */
public class Tuner {

    static byte AM = 1, FM = 2;
    Amplifier amplifier;
    byte mode;
    double frequency;

    public Tuner(Amplifier amplifier) {
        this.amplifier = amplifier;
        mode = FM;
    }

    public void on(){
        System.out.println("Tuner is on.");
    }

    public void off(){
        System.out.println("Tuner is off.");
    }

    public void setAM(){
        mode = AM;
    }

    public void setFM(){
        mode = FM;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }


}
