package com.java8.optional;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest2 {

    @Test
    public void whenCreatesEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();
        assert (!empty.isPresent());
    }

    @Test
    public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        String name = "baeldung";
        Optional<String> opt = Optional.of(name);
        assert(opt.isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
        String name = null;
        Optional.of(name);
    }

    public static void main(String[] args) {
        OptionalTest2 test2 = new OptionalTest2();
        test2.whenCreatesEmptyOptional_thenCorrect();
        test2.givenNonNull_whenCreatesNonNullable_thenCorrect();
        test2.givenNull_whenThrowsErrorOnCreate_thenCorrect();

//        Optional<String> str1 = Optional.of(null);
        Optional<String> str2 = Optional.ofNullable(null);

//        System.out.println(str1.map(s->s.toLowerCase()).get());
        System.out.println(str2.map(s->s.toLowerCase()).orElseThrow(()->new RuntimeException("ea")));
    }
}
