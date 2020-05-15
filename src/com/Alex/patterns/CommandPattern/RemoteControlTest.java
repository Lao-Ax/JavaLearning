package com.Alex.patterns.CommandPattern;

import com.Alex.patterns.CommandPattern.Commands.GarageDoorOpenCommand;
import com.Alex.patterns.CommandPattern.Commands.LightOnCommand;
import com.Alex.patterns.CommandPattern.Devices.GarageDoor;
import com.Alex.patterns.CommandPattern.Devices.Light;

/**
 * Created by Alex on 22.11.2015 022.
 */
public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();

        Light light = new Light("");
        LightOnCommand lightOn = new LightOnCommand(light);
        simpleRemoteControl.setCommand(lightOn);
        simpleRemoteControl.buttonWasPressed();

        GarageDoor garageDoor = new GarageDoor("");
        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);
        simpleRemoteControl.setCommand(garageOpen);
        simpleRemoteControl.buttonWasPressed();
    }
}
