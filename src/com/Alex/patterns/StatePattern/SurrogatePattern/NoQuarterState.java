package com.Alex.patterns.StatePattern.SurrogatePattern;

/**
 * Created by Alex on 23.01.2016 023.
 */
public class NoQuarterState implements State {
    private transient GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() { // перейти в состояние Есть монетка
        System.out.println("You inserted a quarter.");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() { // сообщить, что нету монетки
        System.out.println("You haven't inserted a quarter.");
    }

    @Override
    public void turnCrank() { // сообщить, что нужно положить монетку
        System.out.println("You turned, but there is no quarter.");
    }

    @Override
    public void dispense() { // сообщить, что нужно положить монетку
        System.out.println("You need to pay first.");
    }

    @Override
    public String toString() {
        return "Machine is waiting for quarter.";
    }
}
