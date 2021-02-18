package com.alg.recursion;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0, multiplier = 1;
        while(i < s.length()) {
            // If found digital slot in string
            if(Character.isDigit(s.charAt(i))) {
                int digitStart = i; // There might be multiple adjacent digits
                while(Character.isDigit(s.charAt(i))){
                    i++;
                } // When digit ends, followed by a bracket beginning '['
                multiplier = Integer.valueOf(s.substring(digitStart, i));
                //find the bracket end 3[ ..[..]..[[..]]..] ...
                int end = findBracketEnding(s, i);
                String inner = decodeString(s.substring(i+1, end));
                while (multiplier > 0) {
                    sb.append(inner);
                    multiplier--;
                }
                i = end + 1;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    private int findBracketEnding (String s, int start) {
        int end = start;
        int j = start + 1, counter = 1;
        while(counter != 0){
            if(s.charAt(j) == '['){
                counter++;
            }
            if(s.charAt(j) == ']'){
                counter--;
            }
            j++;
        }
        return --j;
    }

    public static void main(String[] args) {
        String s = "abc11[ERIC2[dawg]]def";
        DecodeString solution = new DecodeString();
        System.out.println(solution.decodeString(s));

//        System.out.println(solution.findBracketEnding(s, 3+1));
//        String sub = s.substring(4+1, 10-1);
//        System.out.println(sub);
//        System.out.println(s.substring(10, 13));

//        System.out.println(Character.isDigit('a'));
//        System.out.println(Character.isDigit('3'));
//        System.out.println(Character.isAlphabetic('a'));
//        System.out.println(Character.isAlphabetic('3'));
    }
}
