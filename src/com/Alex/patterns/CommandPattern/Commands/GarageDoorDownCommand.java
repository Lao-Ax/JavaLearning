package com.Alex.patterns.CommandPattern.Commands;

import com.Alex.patterns.CommandPattern.Devices.GarageDoor;

/**
 * Created by Alex on 24.11.2015 024.
 */
public class GarageDoorDownCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorDownCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void undo() {
        garageDoor.up();
    }

    @Override
    public void execute() {
        garageDoor.down();
    }
}
