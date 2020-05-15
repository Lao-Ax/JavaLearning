package com.Alex.patterns.MvcPattern;

/**
 * Created by Alex on 01.05.2016 001.
 */
public class DJTest {
     public static void main(String[] args){
         BeatModelInterface model = new BeatModel();
         ControllerInterface controller = new BeatController(model);
     }
}
