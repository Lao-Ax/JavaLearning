package com.Alex.patterns.FacadePattern.Devices;

/**
 * Created by Alex on 03.12.2015 003.
 */
public class Amplifier {
    DvdPlayer dvdPlayer;
    CdPlayer cdPlayer;
    Tuner tuner;

    public void setSurroundAudio(){

    }

    public void on(){
        System.out.println("Amplifier is on.");
    }

    public void off(){
        System.out.println("Amplifier is off.");
    }

    public void setCd(){
        System.out.println("CD mode.");
    }

    public void setDvd(DvdPlayer dvdPlayer){
        this.dvdPlayer = dvdPlayer;
        System.out.println("DVD mode.");
    }

    public void setStereoSound(){
        System.out.println("Stereo mode.");
    }

    public void setSurroundSound(){
        System.out.println("Surround mode.");
    }

    public void setTuner(){
        System.out.println("Tuner mode.");
    }

    public void setVolume(int i){
        System.out.println("Volume is " + i);
    }
}
