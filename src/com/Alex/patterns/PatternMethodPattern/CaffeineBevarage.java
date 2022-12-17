package com.Alex.patterns.PatternMethodPattern;

/**
 * Created by Alex on 23.12.2015 023.
 */
public abstract class CaffeineBevarage {

    /* This is THE PATTERN METHOD. It's FINAL because subclasses don't have to modify it. */
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater(){
        System.out.println("Boiling water.");
    }

    void pourInCup(){
        System.out.println("Pouring into cup.");
    }

    /* This is a HOOK. It's a template of method which could do or not to do anything. If a subclass needs
     * a special steps, it can implement them here. */
    boolean customerWantsCondiments() {
        return true;
    }
}
