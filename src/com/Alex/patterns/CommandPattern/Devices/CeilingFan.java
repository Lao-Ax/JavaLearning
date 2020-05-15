package com.Alex.patterns.CommandPattern.Devices;

/**
 * Created by Alex on 24.11.2015 024.
 */
public class CeilingFan {

    private enum Speeds {
        OFF(0), LOW(1), MEDIUM(2), HIGH(3);

        private int speed;
        private Speeds(int i){
            speed = i;
        }

        public int getSpeed() {
            return speed;
        }

    }

    private Speeds speed;
    private String name;

    public CeilingFan(String name) {
        this.name = name;
        speed = Speeds.OFF;
    }

    public void high(){
        speed = Speeds.HIGH;
        System.out.println("Fan in on speed " + Speeds.HIGH);
    }

    public void medium(){
        speed = Speeds.MEDIUM;
        System.out.println("Fan in on speed " + Speeds.MEDIUM);
    }

    public void low(){
        speed = Speeds.LOW;
        System.out.println("Fan in on speed " + Speeds.LOW);
    }

    public void off(){
        System.out.println("Fan is off");
        speed = speed.OFF;
    }

    public int getSpeed(){
        return speed.getSpeed();
    }
}
