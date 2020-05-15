package com.Alex.patterns.CompositePattern_1;

import com.Alex.patterns.CompositePattern_1.Factory.AbstractDuckFactory;
import com.Alex.patterns.CompositePattern_1.Factory.CountingDuckFactory;
import com.Alex.patterns.CompositePattern_1.Gooses.Goose;
import com.Alex.patterns.CompositePattern_1.Observable.Quackable;

public class DuckSimulator_factory_flock {

    public static void main(String[] args) {
        DuckSimulator_factory_flock duckSimulator = new DuckSimulator_factory_flock();
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

        System.out.println("\nDuck Simulator: with decorator and factory and composite pattern");

        Flock flockOfDucks = new Flock();

        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallards = new Flock();

        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();

        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);

        flockOfDucks.add(flockOfMallards);

        System.out.println("\nDuck Simulator: Whole flock simulator");
        simulate(flockOfDucks);

        System.out.println("\nDuck Simulator: Mallard flock simulator");
        simulate(flockOfMallards);

        System.out.println("\nThe ducks quacked " + QuackCounter.getNumberOfQuaks() + " times.");
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }


}
