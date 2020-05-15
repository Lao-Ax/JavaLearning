package com.Alex.patterns.FacadePattern;

import com.Alex.patterns.FacadePattern.Devices.*;

/**
 * Created by Alex on 07.12.2015 007.
 */
public class HomeTheaterTestDrive {
    public static void main (String[] args) {
        Amplifier amplifier = new Amplifier();
        Tuner tuner = new Tuner(amplifier);
        DvdPlayer dvdPlayer = new DvdPlayer(amplifier);
        Projector projector = new Projector();
        CdPlayer cdPlayer = new CdPlayer(amplifier);
        TheaterLights lights = new TheaterLights();
        PopcornPopper popper = new PopcornPopper();
        Screen screen = new Screen();


        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                amplifier,
                tuner,
                dvdPlayer,
                cdPlayer,
                projector,
                lights,
                screen,
                popper);

        homeTheater.watchMovie("Cats on the roof.");
        homeTheater.endMovie();
    }
}
