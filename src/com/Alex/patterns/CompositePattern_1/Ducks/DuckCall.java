package com.Alex.patterns.CompositePattern_1.Ducks;

import com.Alex.patterns.CompositePattern_1.Observable.Observable;
import com.Alex.patterns.CompositePattern_1.Observable.Quackable;
import com.Alex.patterns.CompositePattern_1.Observer.Observer;

public class DuckCall implements Quackable {
    Observable observable;

    public DuckCall() {
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Kwak.");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
