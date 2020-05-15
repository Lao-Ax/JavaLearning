package com.Alex.patterns.StatePattern.SurrogatePattern;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Alex on 23.01.2016 023.
 */
public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
    private State soldOutState,
        noQuarterState,
        hasQuarterState,
        soldState,
        winnerState;

    private State currentState = soldOutState;
    private int ballsCount = 0;
    private String location;

    public GumballMachine(int initialBallsCount, String location) throws RemoteException{
        this.soldOutState = new SoldOutState(this);
        this.noQuarterState = new NoQuarterState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.soldState = new SoldState(this);
        this.winnerState = new WinnerState(this);
        this.ballsCount = initialBallsCount;
        if (initialBallsCount >0) {
            currentState = noQuarterState;
        }
        this.location = location;
    }

    public void insertQuarter(){
        currentState.insertQuarter();
    }

    public void ejectQuarter(){
        currentState.ejectQuarter();
    }

    public void turnCrank(){
        currentState.turnCrank();
        currentState.dispense();
    }

    void setState(State state){
        this.currentState = state;
    }

    void releaseBall(){
        System.out.println("A gumball comes rolling out the slot...");
        if (ballsCount > 0) {
            ballsCount--;
        }
    }

    void refill(int ballsCount) {
        this.ballsCount = ballsCount;
        if (currentState instanceof SoldOutState) {
            currentState = noQuarterState;
        }
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public int getBallsCount() {
        return ballsCount;
    }

    public State getWinnerState() {
        return winnerState;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        String str = "\nInventory: " + ballsCount + "\n" + currentState.toString();
        return str;
    }
}
