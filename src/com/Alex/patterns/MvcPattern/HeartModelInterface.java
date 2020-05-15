package com.Alex.patterns.MvcPattern;

/**
 * Created by Alex on 02.05.2016 002.
 */
public interface HeartModelInterface {
    int getHeartRate();
    void registerObserver(BeatObserver o);
    void registerObserver(BPMObserver o);
    void removeObserver(BeatObserver o);
    void removeObserver(BPMObserver o);

}
