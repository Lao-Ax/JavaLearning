package com.Alex.patterns.ComponentPattern;

import com.Alex.patterns.IteratorPattern.CompositeIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 16.01.2016 016.
 */
public class Menu extends MenuComponent{
    java.util.Iterator<MenuComponent> iterator = null;

    List<MenuComponent> menuComponents = new ArrayList<>();
    String name,
           description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public void print() {
        System.out.print("\n" + name);
        System.out.println(", " + description);
        System.out.println("-------------------");
        for (MenuComponent m : menuComponents) {
            m.print();
        }
    }

    @Override
    public java.util.Iterator createIterator() {
        if (iterator == null)
            iterator = new CompositeIterator(menuComponents.iterator());
        return iterator;
    }
}
