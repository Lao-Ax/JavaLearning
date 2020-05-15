package com.Alex.patterns.IteratorPattern;

/**
 * Created by Alex on 14.01.2016 014.
 */
public class Waitress {
    Menu dinerMenu;
    Menu breakfastMenu;
    Menu cafeMenu;

    public Waitress(Menu dinerMenu, Menu breakfastMenu, Menu cafeMenu) {
        this.dinerMenu = dinerMenu;
        this.breakfastMenu = breakfastMenu;
        this.cafeMenu = cafeMenu;
    }

    public void printMenu(){
        java.util.Iterator breakfastIterator = breakfastMenu.createIterator();
        java.util.Iterator dinerIterator = dinerMenu.createIterator();
        java.util.Iterator cafeIterator = cafeMenu.createIterator();

        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(breakfastIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
        System.out.println("\nDINNER");
        printMenu(cafeIterator);
    }

    private void printMenu(java.util.Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem item = (MenuItem) iterator.next();
            System.out.println(item.getName() + ", ");
            System.out.println(item.getPrice() + " -- ");
            System.out.println(item.getDescription());
        }
    }
}
