package com.Alex.patterns.CommandPattern.Devices;

/**
 * Created by Alex on 22.11.2015 022.
 */
public class GarageDoor {

    private String name;

    public GarageDoor(String name) {
        this.name = name;
    }

    public void up(){
        System.out.println("Garage door is opened.");
    }

    public void down(){
        System.out.println("Garage door is closed.");
    }
}
