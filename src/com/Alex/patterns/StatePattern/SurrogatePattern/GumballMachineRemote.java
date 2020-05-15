package com.Alex.patterns.StatePattern.SurrogatePattern;

import java.rmi.*;

/**
 * Created by Alex on 09.02.2016 009.
 */
public interface GumballMachineRemote extends Remote {
    public int getBallsCount() throws RemoteException;
    public String getLocation() throws RemoteException;
    public State getCurrentState() throws RemoteException;
}
