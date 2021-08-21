package com.java.se.inheritancePolymorphism.question7;

public class MeatHen extends Hen {
    public int temperature;
    public double weight;

    public void call() {
        System.out.println("Meat Hen clucking;");
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public MeatHen () {
        this.temperature = 43;
        this.weight = 4.4;
        System.out.println("Meat Hen created;");
    }

//    class Egg {
//        public int temperature;
//        public double weight;
//
//        public void call() {
//            System.out.println("Meat Hen Egg cannot make any sound...");
//        }
//
//        public int getTemperature() {
//            return temperature;
//        }
//
//        public void setTemperature(int temperature) {
//            this.temperature = temperature;
//        }
//
//        public Egg (){
//            this.temperature = 40;
//            this.weight = 0.04;
//            System.out.println("Meat Hen Egg created;");
//        }
//    }
}
