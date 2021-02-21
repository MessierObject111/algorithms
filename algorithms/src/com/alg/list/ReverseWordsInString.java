package com.alg.list;

import java.util.ArrayList;

public class ReverseWordsInString {
    public static void main(String[] args) {
//        String input = " the sky is  blue ";
        String input = "  ";
        String answer = "blue is sky the";
        String output = reverseWords(input);
        System.out.println(answer.equals(output));
        System.out.println(output);
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() < 1) return s;
        s = s.trim();
        String[] list = s.split(" ");
        ArrayList<String> reversedList = new ArrayList<>();
        for(int i = list.length - 1; i >= 0; i--) {
            reversedList.add(list[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < reversedList.size(); i++) {
            String temp = reversedList.get(i);
            if(!temp.equals("")){
                sb.append(temp);
                if (i != reversedList.size()-1) sb.append(" ");
            }
        }
        return sb.toString();
    }
}
