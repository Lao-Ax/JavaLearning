package com.Alex.patterns.CommandPattern.Commands;

import com.Alex.patterns.CommandPattern.Devices.CeilingFan;

/**
 * Created by Alex on 24.11.2015 024.
 */
public class CeilingFanOffCommand implements Command {
    private CeilingFan ceilingFan;
    private int prevSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.off();
    }

    @Override
    public void undo() {
        switch (prevSpeed) {
            case 0: {ceilingFan.off(); break;}
            case 1: {ceilingFan.low(); break;}
            case 2: {ceilingFan.medium(); break;}
            case 3: {ceilingFan.high();}
        }
    }
}
