package com.Alex.patterns.StatePattern.SurrogatePattern;

import java.rmi.RemoteException;

/**
 * Created by Alex on 09.02.2016 009.
 */
public class GambleMonitor {
    GumballMachineRemote gumballMachine;

    public GambleMonitor(GumballMachineRemote gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void report(){
        try {
            System.out.println("Machine location" + gumballMachine.getLocation());
            System.out.println("Machine inventory" + gumballMachine.getBallsCount());
            System.out.println("Machine state" + gumballMachine.getCurrentState());
        }catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
