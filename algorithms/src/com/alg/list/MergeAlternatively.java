package com.alg.list;

public class MergeAlternatively {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i< Math.max(word1.length(), word2.length()); i++) {
            if(i < word1.length()) result.append(word1.charAt(i));
            if(i < word2.length()) result.append(word2.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MergeAlternatively s = new MergeAlternatively();
        String word1 = "abcde";
        String word2 = "12345678";
        String result = s.mergeAlternately(word1, word2);
        System.out.println(result);
    }
}
