package com.Alex.patterns.CompositePattern_1.Observer;

import com.Alex.patterns.CompositePattern_1.QuackObservable;

public class Quackologist implements Observer {

    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: " + duck + " just quacked.");
    }
}
