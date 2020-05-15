package com.Alex.patterns.ComponentPattern;

/**
 * Created by Alex on 16.01.2016 016.
 */
public class MenuItem extends MenuComponent {
    String name,
           description;
    double price;
    boolean vegetarian;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.vegetarian = vegetarian;
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
    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public void print() {
        System.out.print("  " + name);
        if (vegetarian) System.out.print("(v)");
        System.out.println(",  " + price);
        System.out.println("     -- " + description);
    }

    @Override
    public java.util.Iterator createIterator() {
        return new NullIterator();
    }
}
