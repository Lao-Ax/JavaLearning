package com.Alex.patterns.CommandPattern.Commands;

import com.Alex.patterns.CommandPattern.Devices.Stereo;

/**
 * Created by Alex on 24.11.2015 024.
 */
public class StereoOffCommand implements Command {
    Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
    }
}
