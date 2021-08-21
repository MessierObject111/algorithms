package com.java.se.inheritancePolymorphism.question7;

public abstract class Chicken {
    public int temperature;
    public double weight;

    public abstract void call();

    public abstract int getTemperature();

    public abstract void setTemperature(int temperature);

    public abstract double getWeight();

    public abstract void setWeight(double weight);

    public Chicken () {
        // Even it is abstract class, and cannot be instantiated, the constructor here will be called for child class
        // instantiation nevertheless.
        System.out.println("Chicken created;");
    }
}
