package com.Alex.patterns.StatePattern;

import java.util.Random;

/**
 * Created by Alex on 23.01.2016 023.
 */
public class HasQuarterState implements State {
    private GumballMachine gumballMachine;
    Random randomWinner = new Random(System.currentTimeMillis());

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() { // вернуть монетку
        System.out.println("You can't insert another quarter.");
    }

    @Override
    public void ejectQuarter() { // перейти в состояние Нет монетки
        System.out.println("Quarter returned.");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() { // перейти в состояние Выдать шарик
        System.out.println("You turned...");
        int winner = randomWinner.nextInt(10);
        if ((winner == 0) && (gumballMachine.getBallsCount() > 1)) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() { // сообщить, что нужно дернуть рычаг
        System.out.println("No gumball dispensed.");
    }

    @Override
    public String toString() {
        return "Machine is waiting for turning the crank.";
    }
}
