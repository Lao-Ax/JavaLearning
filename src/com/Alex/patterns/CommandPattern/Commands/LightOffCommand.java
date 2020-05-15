package com.Alex.patterns.CommandPattern.Commands;

import com.Alex.patterns.CommandPattern.Devices.Light;

/**
 * Created by Alex on 24.11.2015 024.
 */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
