package com.alg.string;

public class SubPalindromicStrings {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int sum = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            for(int j = i + 1; j < s.length(); j++) {
//                String subStr = s.substring(i, j);
                boolean isPalindromic = checkPalindrome(s, i, j);
                if(isPalindromic) {
                    sum++;
                }
            }
        }
        return s.length() + sum;
    }

    private boolean checkPalindrome (String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input_1 = "aaa";
        String input_2 = "aba";
        SubPalindromicStrings sol = new SubPalindromicStrings();
        int count_1 = sol.countSubstrings(input_1);
        int count_2 = sol.countSubstrings(input_2);
        System.out.println(count_1);
        System.out.println(count_2);
    }
}
