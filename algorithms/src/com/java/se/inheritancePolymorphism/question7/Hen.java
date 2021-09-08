package com.java.se.inheritancePolymorphism.question7;

public class Hen extends Chicken {
    public int temperature;
    public double weight;

    public void call() {
        System.out.println("Hen clucking;");
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Hen () {
        this.temperature = 41;
        this.weight = 3.3;
        System.out.println("Hen created;");
    }

    class Egg {
        public int temperature;
        public double weight;

        public void call() {
            System.out.println("Egg cannot make any sound...");
        }

        public int getTemperature() {
            return temperature;
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
        }

        public Egg (){
            this.temperature = 40;
            this.weight = 0.05;
            System.out.println("Egg created;");
        }
    }
}
