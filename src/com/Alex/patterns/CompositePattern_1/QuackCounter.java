package com.Alex.patterns.CompositePattern_1;

import com.Alex.patterns.CompositePattern_1.Observable.Quackable;
import com.Alex.patterns.CompositePattern_1.Observer.Observer;

/**
 * Класс декоратора, который позволяет научить уток считать кол-во кряков, без изменения кода уток.
 */
public class QuackCounter implements Quackable {
    Quackable duck;
    static int numberOfQuaks = 0;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuaks++;
    }

    public static int getNumberOfQuaks(){
        return numberOfQuaks;
    }

    @Override
    public void registerObserver(Observer observer) {
        duck.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        duck.notifyObservers();
    }
}
