package com.Alex.patterns.CompositePattern_1;

import com.Alex.patterns.CompositePattern_1.Factory.AbstractDuckFactory;
import com.Alex.patterns.CompositePattern_1.Factory.CountingDuckFactory;
import com.Alex.patterns.CompositePattern_1.Gooses.Goose;
import com.Alex.patterns.CompositePattern_1.Observable.Quackable;
import com.Alex.patterns.CompositePattern_1.Observer.Quackologist;

public class DuckSImulator_observable { // стр. 543 книги - лучше переписать все заметки в код.

    public static void main(String[] args){
        DuckSImulator_observable simulator = new DuckSImulator_observable();
        AbstractDuckFactory factory = new CountingDuckFactory();

        simulator.simulate(factory);
    }

    void simulate(AbstractDuckFactory duckFactory){
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        //Quackable gooseDuck = duckFactory.createDuckGoose();

        Flock flockOfDucks = new Flock();

        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        /* стая 2 */

        Flock flockOfMallards = new Flock();

        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();

        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);

        /* объединения стай */
        flockOfDucks.add(flockOfMallards);

        System.out.println("\nDuck Simulator: with Observer");
        Quackologist quackologist = new Quackologist();
        flockOfDucks.registerObserver(quackologist);

        simulate(flockOfDucks);

        System.out.println("\nThe ducks quacked " + QuackCounter.getNumberOfQuaks() + " times.");
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }

}
