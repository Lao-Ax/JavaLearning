package com.Alex.patterns.CommandPattern;

import com.Alex.patterns.CommandPattern.Commands.Command;

/**
 * Created by Alex on 22.11.2015 022.
 */
public class SimpleRemoteControl {
    private Command slot;

    public  SimpleRemoteControl(){}

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
