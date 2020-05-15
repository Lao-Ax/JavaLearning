package com.Alex.patterns.CompositePattern_1;

import com.Alex.patterns.CompositePattern_1.Observable.Quackable;
import com.Alex.patterns.CompositePattern_1.Observer.Observer;

import java.util.ArrayList;

/**
 * Created by Alex on 20.04.2016 020.
 */
public class Flock implements Quackable {
    ArrayList<Quackable> quakers = new ArrayList<>();

    public void add(Quackable quacker) {
        quakers.add(quacker);
    }

    @Override
    public void quack() {
        for (Quackable q : quakers) {
            q.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        for (Quackable quackable : quakers) {
            quackable.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
        // to do nothing
    }
}
