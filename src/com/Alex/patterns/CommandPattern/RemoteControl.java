package com.Alex.patterns.CommandPattern;

import com.Alex.patterns.CommandPattern.Commands.Command;
import com.Alex.patterns.CommandPattern.Commands.noCommand;

import java.util.Stack;

/**
 * Created by Alex on 24.11.2015 024.
 */
public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    Stack<Command> undoCommands = new Stack<Command>();

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new noCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }

        undoCommands.push(noCommand);
    }

    public void setCommand(int slot, Command onCommand, Command offCommand){
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPressed(int slot){
        onCommands[slot].execute();
        undoCommands.push(onCommands[slot]);
    }

    public void offButtonWasPressed(int slot){
        offCommands[slot].execute();
        undoCommands.push(offCommands[slot]);
    }

    public void undoButtonWasPressed(){
        if (undoCommands.size() == 1)
            undoCommands.peek().undo();
        else
            undoCommands.pop().undo();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n------ Remote Control ------\n");
        for (int i = 0; i < 7; i++) {
            sb.append("[slot " + i + "] "
                    + onCommands[i].getClass().getSimpleName() + "   "
                    + offCommands[i].getClass().getSimpleName() + "\n");
        }
        sb.append("[undo] " + undoCommands.getClass().getSimpleName() + "\n");
        return sb.toString();
    }
}
