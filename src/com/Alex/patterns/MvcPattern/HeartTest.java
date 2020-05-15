package com.Alex.patterns.MvcPattern;

/**
 * Created by Alex on 02.05.2016 002.
 */
public class HeartTest {
    public static void main(String[] args){
        HeartModel heartModel = new HeartModel();
        ControllerInterface controller = new HeartController(heartModel);
    }
}
