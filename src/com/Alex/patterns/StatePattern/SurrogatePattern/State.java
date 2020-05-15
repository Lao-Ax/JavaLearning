package com.Alex.patterns.StatePattern.SurrogatePattern;

import java.io.Serializable;

/**
 * Created by Alex on 23.01.2016 023.
 */
public interface State extends Serializable {
    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
}
