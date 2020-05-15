package com.Alex.patterns.CompositePattern_1;

import com.Alex.patterns.CompositePattern_1.Factory.AbstractDuckFactory;
import com.Alex.patterns.CompositePattern_1.Factory.CountingDuckFactory;
import com.Alex.patterns.CompositePattern_1.Gooses.Goose;
import com.Alex.patterns.CompositePattern_1.Observable.Quackable;

public class DuckSimulator_factory {

    public static void main(String[] args) {
        DuckSimulator_factory duckSimulator = new DuckSimulator_factory();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        duckSimulator.simulate(duckFactory);
    }

    private void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        //Quackable gooseDuck = duckFactory.createDuckGoose();

        System.out.println("\nDuck Simulator: with decorator");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);

        System.out.println("The ducks quacked " + QuackCounter.getNumberOfQuaks() + " times.");
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }


}
