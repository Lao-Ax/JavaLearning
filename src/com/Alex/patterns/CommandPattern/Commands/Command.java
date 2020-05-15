package com.Alex.patterns.CommandPattern.Commands;

/**
 * Created by Alex on 22.11.2015 022.
 */
public interface Command {
    public void execute();

    public void undo();
}
