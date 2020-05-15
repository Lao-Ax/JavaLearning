package com.Alex.patterns.ComponentPattern;

import java.util.Iterator;

/**
 * Created by Alex on 16.01.2016 016.
 */
public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu(){
        allMenus.print();
    }

    public void printVegetarianMenu(){
        Iterator<MenuComponent> iterator = allMenus.createIterator();
        System.out.println("\nVEGETARIAN MENU\n----");
        while (iterator.hasNext()){
            MenuComponent menuComponent = iterator.next();
            try {
                if (menuComponent.isVegetarian()){
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException e) {

            }
        }
    }
}
