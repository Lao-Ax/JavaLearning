package com.Alex.patterns.IteratorPattern;

/**
 * Created by Alex on 14.01.2016 014.
 */
public class MenuTestDrive {
    public static void main(String[] args) {
        BreakfastMenu breakfastMenu = new BreakfastMenu();
        DinerMenu dinerMenu = new DinerMenu();
        CafeMenu cafeMenu = new CafeMenu();

        Waitress waitress = new Waitress(dinerMenu, breakfastMenu, cafeMenu);

        waitress.printMenu();
    }
}
