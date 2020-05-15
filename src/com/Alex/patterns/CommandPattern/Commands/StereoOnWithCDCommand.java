package com.Alex.patterns.CommandPattern.Commands;

import com.Alex.patterns.CommandPattern.Devices.Stereo;

/**
 * Created by Alex on 24.11.2015 024.
 */
public class StereoOnWithCDCommand implements Command {
    private Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void undo() {
        stereo.off();
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }
}
