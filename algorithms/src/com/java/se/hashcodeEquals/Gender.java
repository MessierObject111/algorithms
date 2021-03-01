package com.java.se.hashcodeEquals;

public enum Gender {
    MALE(0),
    FEMALE(1);

    private final int index;

    Gender(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
