package com.Alex.patterns.IteratorPattern;

import java.util.*;

/**
 * Created by Alex on 14.01.2016 014.
 */
public class BreakfastMenu implements Menu {
    ArrayList<MenuItem> menuItems;

    public BreakfastMenu() {
        menuItems = new ArrayList<>();

        addItem("K&B Pancake Breakfast", "Pancake with scramble eggs, and roast", true, 2.99);
        addItem("Regular Pancake Breakfast", "Pancake with field eggs, sausage", false, 2.99);
        addItem("Blueberry Pancake", "Pancake made with fresh blueberries", true, 3.49);
        addItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59);
    }

    public void addItem(String name, String description, boolean vegeterian, double price) {
        menuItems.add(new MenuItem(name, description, vegeterian, price));
    }

//    public ArrayList<MenuItem> getMenuItems() {
//        return menuItems;
//    } // убираем за ненадобностью

    // пишем новый
    public java.util.Iterator createIterator(){
        return menuItems.iterator();
    }
}
