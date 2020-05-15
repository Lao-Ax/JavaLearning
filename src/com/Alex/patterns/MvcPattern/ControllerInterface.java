package com.Alex.patterns.MvcPattern;

/**
 * Created by Alex on 29.04.2016 029.
 */
public interface ControllerInterface {
    void start();
    void stop();
    void increaseBPM();
    void decreaseBPM();
    void setBPM(int bpm);
}
