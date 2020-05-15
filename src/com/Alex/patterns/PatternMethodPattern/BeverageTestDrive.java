package com.Alex.patterns.PatternMethodPattern;

/**
 * Created by Alex on 23.12.2015 023.
 */
public class BeverageTestDrive {
    public static void main(String[] args) {

        Tea tea = new Tea();
        Coffee coffee = new CoffeeWithHook();

        System.out.println("\nMaking tea...");
        tea.prepareRecipe();

        System.out.println("\nMaking coffee...");
        coffee.prepareRecipe();
    }
}
