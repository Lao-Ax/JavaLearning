package com.Alex.patterns.CommandPattern.Commands;

/**
 * Created by Alex on 24.11.2015 024.
 */
public class noCommand implements Command {
    @Override
    public void execute() {
        System.out.println("There is no command.");
    }

    @Override
    public void undo() {
        System.out.println("There is no command.");
    }
}
