package com.Alex.patterns.CompositePattern_1.Factory;

import com.Alex.patterns.CompositePattern_1.Ducks.DuckCall;
import com.Alex.patterns.CompositePattern_1.Ducks.MallardDuck;
import com.Alex.patterns.CompositePattern_1.Ducks.RedheadDuck;
import com.Alex.patterns.CompositePattern_1.Ducks.RubberDuck;
import com.Alex.patterns.CompositePattern_1.GooseAdapter;
import com.Alex.patterns.CompositePattern_1.Gooses.Goose;
import com.Alex.patterns.CompositePattern_1.Observable.Quackable;

/**
 * Created by Alex on 20.04.2016 020.
 */
public class DuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedheadDuck() {
        return new RedheadDuck();
    }

    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }

    @Override
    public Quackable createDuckGoose() {
        return new GooseAdapter(new Goose());
    }
}
