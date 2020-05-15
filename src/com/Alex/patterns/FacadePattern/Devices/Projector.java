package com.Alex.patterns.FacadePattern.Devices;

/**
 * Created by Alex on 04.12.2015 004.
 */
public class Projector {
    DvdPlayer dvdPlayer;

    static int TV = 1, WIDE = 2;
    int mode = 1;

    public void on(){
        System.out.println("Projector is on.");
    }

    public void off(){
        System.out.println("Projector is off.");
    }

    public void tvMode(){
        mode = TV;
    }

    public void wideScreenMode(){
        mode = WIDE;
    }


}
