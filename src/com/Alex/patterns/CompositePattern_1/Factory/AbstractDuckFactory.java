package com.Alex.patterns.CompositePattern_1.Factory;

import com.Alex.patterns.CompositePattern_1.Observable.Quackable;

/**
 * Created by Alex on 20.04.2016 020.
 */
public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();
    public abstract Quackable createRedheadDuck();
    public abstract Quackable createDuckCall();
    public abstract Quackable createRubberDuck();
    public abstract Quackable createDuckGoose();
}
