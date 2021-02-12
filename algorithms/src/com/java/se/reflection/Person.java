package com.java.se.reflection;

public class Person {
    private int age = 0;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private int privateAge () {
        return this.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
