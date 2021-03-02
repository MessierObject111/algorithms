package com.java.se.generics;

public class Student<T> {
    T age; //We can pass String, int, long or double
    Student(T age){
        this.age = age;
    }
    public void display() {
        System.out.println("Value: "+ this.age);
    }

    public static void main(String args[]) {
        Student<Float> std1 = new Student<Float>(25.5f);
        std1.display();
        Student<String> std2 = new Student<String>("25");
        std2.display();
        Student<Integer> std3 = new Student<Integer>(25);
        std3.display();
    }
}
