package com.Alex.patterns.CommandPattern.Commands;

/**
 * Created by Alex on 26.11.2015 026.
 */
public class MacroCommand implements Command {
    Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command cmd : commands) {
            cmd.execute();
        }

    }

    @Override
    public void undo() {
        for (Command cmd : commands) {
            cmd.undo();
        }
    }
}
