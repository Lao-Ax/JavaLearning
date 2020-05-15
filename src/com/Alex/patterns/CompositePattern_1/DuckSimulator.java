package com.Alex.patterns.CompositePattern_1;

import com.Alex.patterns.CompositePattern_1.Ducks.DuckCall;
import com.Alex.patterns.CompositePattern_1.Ducks.MallardDuck;
import com.Alex.patterns.CompositePattern_1.Ducks.RedheadDuck;
import com.Alex.patterns.CompositePattern_1.Ducks.RubberDuck;
import com.Alex.patterns.CompositePattern_1.Gooses.Goose;
import com.Alex.patterns.CompositePattern_1.Observable.Quackable;

public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        duckSimulator.simulate();
    }

    private void simulate() {
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable gooseDuck = new GooseAdapter(new Goose());

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
