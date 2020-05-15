package com.Alex.patterns.StatePattern.SurrogatePattern;

import java.rmi.*;

/**
 * Created by Alex on 24.01.2016 024.
 */
public class GumBallsMachineTest {
    public static void main(String[] args) {
        GumballMachineRemote gumballMachine = null;

        try {
            gumballMachine = new GumballMachine(5, "CatMachine");
            Naming.rebind("gumballmachine", gumballMachine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
