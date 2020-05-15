package com.Alex.patterns.CompositePattern_1.Factory;

import com.Alex.patterns.CompositePattern_1.Ducks.DuckCall;
import com.Alex.patterns.CompositePattern_1.Ducks.MallardDuck;
import com.Alex.patterns.CompositePattern_1.Ducks.RedheadDuck;
import com.Alex.patterns.CompositePattern_1.Ducks.RubberDuck;
import com.Alex.patterns.CompositePattern_1.GooseAdapter;
import com.Alex.patterns.CompositePattern_1.Gooses.Goose;
import com.Alex.patterns.CompositePattern_1.QuackCounter;
import com.Alex.patterns.CompositePattern_1.Observable.Quackable;

/**
 * Created by Alex on 20.04.2016 020.
 */
public class CountingDuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackCounter(new RedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }

    @Override
    public Quackable createDuckGoose() {
        return new QuackCounter(new GooseAdapter(new Goose()));
    }
}
