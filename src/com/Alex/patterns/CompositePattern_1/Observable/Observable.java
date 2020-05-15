package com.Alex.patterns.CompositePattern_1.Observable;

import com.Alex.patterns.CompositePattern_1.Observer.Observer;
import com.Alex.patterns.CompositePattern_1.QuackObservable;

import java.util.ArrayList;

public class Observable implements QuackObservable {

    ArrayList<Observer> observers = new ArrayList<>();
    QuackObservable duck;

    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(duck);
        }
    }
}
