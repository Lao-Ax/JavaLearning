package com.Alex.patterns.CommandPattern.Commands;

import com.Alex.patterns.CommandPattern.Devices.Light;

/**
 * Created by Alex on 22.11.2015 022.
 */
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
