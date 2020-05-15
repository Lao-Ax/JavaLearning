package com.Alex.patterns.StatePattern.SurrogatePattern;

import java.rmi.Naming;

/**
 * Created by Alex on 09.02.2016 009.
 */
public class MonitorTest {

    public static void main(String[] args) {
        try {
            GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup("rmi://127.0.0.1/gumballmachine");
            GambleMonitor monitor = new GambleMonitor(machine);
            System.out.println(monitor);
            monitor.report();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
