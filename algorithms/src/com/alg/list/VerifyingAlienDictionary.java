package com.alg.list;

public class VerifyingAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length <= 1) return true;
        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            boolean isSorted = checkOrder(word1, word2, order);
            if(!isSorted) return false;
        }
        return true;
    }

    private boolean checkOrder(String word1, String word2, String order) {
        int i = 0;
        while(i < word1.length() && i < word2.length()) {
            int index1 = order.indexOf(word1.charAt(i));
            int index2 = order.indexOf(word2.charAt(i));

            if(index1 == index2) {
                if(i == word1.length() - 1 && i <= word2.length() - 1) return true;
                if(i < word1.length() - 1 && i == word2.length() - 1) return false;
            }

            if(index1 > index2) return false;
            if(index1 < index2) return true;

            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        VerifyingAlienDictionary sol = new VerifyingAlienDictionary();
        String[] words1 = {"hello","leetcode"};
        String order1 = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(sol.isAlienSorted(words1, order1));

        String[] words2 = {"leetcode","leet"};
        String order2 = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(sol.isAlienSorted(words2, order2));
    }
}
