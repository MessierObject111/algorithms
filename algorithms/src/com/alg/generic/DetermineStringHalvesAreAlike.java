package com.alg.generic;

import java.util.HashSet;
import java.util.Set;

public class DetermineStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {

        Set<Character> vowels = new HashSet<Character>();
        //'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
        char[] vowelsList = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for(int i = 0; i < vowelsList.length; i++) {
            vowels.add(vowelsList[i]);
        }

        int length = s.length();
        String s1 = s.substring(0, length/2);
        String s2 = s.substring(length/2, length);
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(vowels.contains(s1.charAt(i))) count1++;
        }
        for(int i = 0; i < s2.length(); i++) {
            if(vowels.contains(s2.charAt(i))) count2++;
        }
        return count1 == count2;
    }

    public static void main(String[] args) {
        DetermineStringHalvesAreAlike sol = new DetermineStringHalvesAreAlike();
        String s1 = "book";
        System.out.println(sol.halvesAreAlike(s1));
        String s2 = "textbook";
        System.out.println(sol.halvesAreAlike(s2));
        String s3 = "MerryChristmas";
        System.out.println(sol.halvesAreAlike(s3));
        String s4 = "AbCdEfGh";
        System.out.println(sol.halvesAreAlike(s4));
    }
}
