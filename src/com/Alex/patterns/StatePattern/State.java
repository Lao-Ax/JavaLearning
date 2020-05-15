package com.Alex.patterns.StatePattern;

/**
 * Created by Alex on 23.01.2016 023.
 */
public interface State {
    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
}
