package com.Alex.patterns.ObserverPattern.Subject;

import com.Alex.patterns.ObserverPattern.Observer.Observer;

/**
 * Created by Alex on 28.10.2015 028.
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
