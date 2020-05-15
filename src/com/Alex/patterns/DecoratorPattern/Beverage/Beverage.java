package com.Alex.patterns.DecoratorPattern.Beverage;

/**
 * Created by Alex on 01.11.2015 001.
 */
public abstract class Beverage {

    private String description = "No description";
    private double cost;
    private int size;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription(){
        return description;
    }

    public double cost(){
        return this.cost;
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size){
        this.size = size;
    }
}
