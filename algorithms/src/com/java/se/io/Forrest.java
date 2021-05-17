package com.java.se.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Tree implements Serializable{
    Integer age;
    String category;

    public Tree(Integer age, String category) {
        this.age = age;
        this.category = category;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "age=" + age +
                ", category='" + category + '\'' +
                '}';
    }
}
public class Forrest implements Serializable {
    public Tree tree = new Tree(100, "Elm");

    public static void main(String[] args) {
        Forrest forrest = new Forrest();
        try {
            FileOutputStream file = new FileOutputStream("test.dat");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(forrest);
            file.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
