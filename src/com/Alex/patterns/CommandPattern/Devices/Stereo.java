package com.Alex.patterns.CommandPattern.Devices;

/**
 * Created by Alex on 24.11.2015 024.
 */
public class Stereo {

    private int volumeLevel;
    private String name;

    public Stereo(String name) {
        this.name = name;
    }

    public void on(){
        System.out.println("Stereo is turned on");
    }

    public void off(){
        System.out.println("Stereo is turned off");
    }

    public void setCD(){
        System.out.println("Stereo is set for CD input");
    }

    public void setDVD(){
        System.out.println("Stereo is set for DVD input");
    }

    public void setRadio(){
        System.out.println("Stereo is set for Radio input");
    }

    public void setVolume(int volumeLevel){
        this.volumeLevel = volumeLevel;
        System.out.println("Volume is on " + volumeLevel);
    }
}
