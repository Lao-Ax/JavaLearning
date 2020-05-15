package com.Alex.patterns.IteratorPattern;

/**
 * Created by Alex on 14.01.2016 014.
 */
public class MenuItem {
    String name;
    String description;
    boolean vegeterian;
    double price;

    public MenuItem(String name, String description, boolean vegeterian, double price) {
        this.name = name;
        this.description = description;
        this.vegeterian = vegeterian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVegeterian() {
        return vegeterian;
    }

    public double getPrice() {
        return price;
    }
}
