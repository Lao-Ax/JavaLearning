package com.Alex.patterns.CommandPattern.Devices;

/**
 * Created by Alex on 22.11.2015 022.
 */
public class Light {
    private String name;

    public Light(String name) {
        this.name = name;
    }

    public void on(){
        System.out.println(name + " Light is on");
    }

    public void off(){
        System.out.println(name + " Light is off");
    }
}
