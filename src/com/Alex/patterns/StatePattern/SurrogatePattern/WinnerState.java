package com.Alex.patterns.StatePattern.SurrogatePattern;

/**
 * Created by Alex on 23.01.2016 023.
 */
public class WinnerState implements State {
    private transient GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() { // сообщить "подождите выдачи шарика"
        System.out.println("Please, wait. We are already giving you a gumball.");
    }

    @Override
    public void ejectQuarter() { // сообщить, что монека не брошена
        System.out.println("Sorry, you've already turned th crank.");
    }

    @Override
    public void turnCrank() { // ничего не делать
        System.out.println("Turning twice doesn't get you another gumball.");
    }

    @Override
    public void dispense() {
        System.out.println("YOU ARE WINNER! You get two balls for your quarter.");
        gumballMachine.releaseBall();
        if (gumballMachine.getBallsCount() <= 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.releaseBall();
            if (gumballMachine.getBallsCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("Oops, out of gumballs!");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }

    @Override
    public String toString() {
        return "We have a winner!";
    }
}
