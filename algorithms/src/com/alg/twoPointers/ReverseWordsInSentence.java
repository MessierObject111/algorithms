package com.alg.twoPointers;

public class ReverseWordsInSentence {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        for(int i = 0; i < split.length; i++) {
            split[i] = reverseString(split[i].toCharArray());
        }
        String result = String.join(" ", split);
        return result;
    }

    public String reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while(left < right) {
            char t = s[left];
            s[left] = s[right];
            s[right] = t;
            left++;
            right--;
        }
        return String.valueOf(s);
    }

    public static void main(String[] args) {
        String s = "Hello world!";
        ReverseWordsInSentence sol = new ReverseWordsInSentence();
        System.out.println(sol.reverseWords(s));
    }
}
