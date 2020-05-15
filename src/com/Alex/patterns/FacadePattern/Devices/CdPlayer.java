package com.Alex.patterns.FacadePattern.Devices;

/**
 * Created by Alex on 03.12.2015 003.
 */
public class CdPlayer {
    Amplifier amplifier;

    public CdPlayer(Amplifier amplifier) {
        this.amplifier = amplifier;
    }

    public void on(){
        System.out.println("CD is on.");
    }

    public void off(){
        System.out.println("CD is off.");
    }

    public void eject(){
        System.out.println("Disk ejected.");
    }

    public void pause(){
        System.out.println("Pause.");
    }

    public void  play(){
        System.out.println("Play.");
    }

    public void play(String movie){
        System.out.println("Play a " + movie);
    }

    public void stop(){
        System.out.println("Stop playing.");
    }

    @Override
    public String toString() {
        return "CdPlayer plays the movie.";
    }
}
