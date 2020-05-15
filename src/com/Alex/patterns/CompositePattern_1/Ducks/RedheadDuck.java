package com.Alex.patterns.CompositePattern_1.Ducks;

import com.Alex.patterns.CompositePattern_1.Observable.Observable;
import com.Alex.patterns.CompositePattern_1.Observer.Observer;
import com.Alex.patterns.CompositePattern_1.Observable.Quackable;

public class RedheadDuck implements Quackable {
    Observable observable;

    public RedheadDuck() {
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack.");
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
