package com.Alex.patterns.CommandPattern;

import com.Alex.patterns.CommandPattern.Commands.*;
import com.Alex.patterns.CommandPattern.Devices.CeilingFan;
import com.Alex.patterns.CommandPattern.Devices.GarageDoor;
import com.Alex.patterns.CommandPattern.Devices.Light;
import com.Alex.patterns.CommandPattern.Devices.Stereo;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

//        remoteControl.undoButtonWasPressed();
//        System.exit(0);

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living room");
        GarageDoor garageDoor = new GarageDoor("");
        Stereo stereo = new Stereo("Living Room");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        CeilingFanOnCommand ceilingFanOnCommand = new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
        GarageDoorDownCommand garageDoorDownCommand = new GarageDoorDownCommand(garageDoor);

        StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);


//        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
//        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
//        remoteControl.setCommand(2, ceilingFanOnCommand, ceilingFanOffCommand);
//        remoteControl.setCommand(3, garageDoorOpenCommand, garageDoorDownCommand);
//        remoteControl.setCommand(4, stereoOnWithCDCommand, stereoOff);

//        System.out.println(remoteControl);

//        for (int i = 0; i < 7; i++) {
//            remoteControl.onButtonWasPressed(i);
//            remoteControl.offButtonWasPressed(i);
//        }
//        remoteControl.onButtonWasPressed(2);
//        remoteControl.offButtonWasPressed(2);
//        System.out.println(remoteControl);
//        remoteControl.undoButtonWasPressed();
//        remoteControl.offButtonWasPressed(2);
//        remoteControl.onButtonWasPressed(2);
//        System.out.println(remoteControl);
//        remoteControl.undoButtonWasPressed();

        Command[] partyOn  = {livingRoomLightOn, kitchenLightOn, stereoOnWithCDCommand, ceilingFanOnCommand};
        Command[] partyOff = {livingRoomLightOff, kitchenLightOff, stereoOff, ceilingFanOffCommand};

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        remoteControl.setCommand(0, partyOnMacro, partyOffMacro);
        System.out.println(remoteControl);

        System.out.println("---- pushing macro ON ----");
        remoteControl.onButtonWasPressed(0);
        System.out.println(remoteControl);

        System.out.println("---- pushing macro OFF ----");
        remoteControl.offButtonWasPressed(0);
        System.out.println(remoteControl);
    }
}
