package com.Alex.patterns.CompositePattern_1.Ducks;

import com.Alex.patterns.CompositePattern_1.Observable.Observable;
import com.Alex.patterns.CompositePattern_1.Observer.Observer;
import com.Alex.patterns.CompositePattern_1.Observable.Quackable;

/**
 * Created by Alex on 20.04.2016 020.
 */
public class RubberDuck implements Quackable {
    Observable observable;

    public RubberDuck() {
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Squeak.");
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
