package com.java8.optional;

import java.util.Optional;

public class OptionalTest2 {
    public static void main(String[] args) {
        Optional<String> str1 = Optional.of(null);
        Optional<String> str2 = Optional.ofNullable(null);

        System.out.println(str1.map(s->s.toLowerCase()).get());
        System.out.println(str2.map(s->s.toLowerCase()).orElseThrow(()->new RuntimeException("ea")));
    }
}
