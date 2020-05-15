package com.Alex.patterns.MvcPattern;

/**
 * Created by Alex on 28.04.2016 028.
 */
public interface BeatModelInterface {

    void initialize();
    void on();
    void off();
    void setBPM(int bpm);
    int getBPM();
    void registerObserver(com.Alex.patterns.MvcPattern.BeatObserver o);
    void removeObserver(com.Alex.patterns.MvcPattern.BeatObserver o);
    void registerObserver(com.Alex.patterns.MvcPattern.BPMObserver o);
    void removeObserver(com.Alex.patterns.MvcPattern.BPMObserver o);
}
