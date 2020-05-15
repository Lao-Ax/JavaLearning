package com.Alex.patterns.StatePattern;

/**
 * Created by Alex on 23.01.2016 023.
 */
public class SoldOutState implements State {
    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Sorry, but there is no gumballs.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, no gumballs - no coins.");
    }

    @Override
    public void turnCrank() { // ничего не делать
        System.out.println("Sorry, but there is no gumballs.");
    }

    @Override
    public void dispense() {
        System.out.println("Sorry, but there is no gumballs.");
    }

    @Override
    public String toString() {
        return "Machine is empty.";
    }
}
