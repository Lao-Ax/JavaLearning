package com.Alex.patterns.CompositePattern_1;

import com.Alex.patterns.CompositePattern_1.Observer.Observer;

public interface QuackObservable {
    public void registerObserver(Observer observer);
    public void notifyObservers();
}
