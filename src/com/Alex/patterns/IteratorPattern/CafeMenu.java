package com.Alex.patterns.IteratorPattern;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by Alex on 15.01.2016 015.
 */
public class CafeMenu implements Menu {
    Hashtable<String, MenuItem> menuItems = new Hashtable<>();

    public CafeMenu(){
        addItem("Veggie Burger and Air Fries", "Veggie burger on a whole wheat bun lettuce, tomato, and fries", true, 3.99);
        addItem("Soup of the day", "A cup of the soap of the day, with a side salad", false, 3.69);
        addItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true, 4.29);

    }

    public void addItem(String name, String description, boolean vegeterian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegeterian, price);
        menuItems.put(menuItem.getName(), menuItem);
    }

    @Override
    public Iterator createIterator() {
        return menuItems.values().iterator();
    }
}
