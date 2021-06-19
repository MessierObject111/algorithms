package com.alg.list;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        //Brute force: try remove one character each time and see if remaining string is valid palindrome
        // This is a bad idea to start with
        // O(N^2)

        //A better idea is to use Valid Palindrome function that takes in start & end, plus string, and returns if the
        // given range in a string is valid palindrome, then call it in a smart way to full fill the 'delete one' requirement
        int l = 0;
        int r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return isPalindromeInRange(l+1, r, s) || isPalindromeInRange(l, r-1,s);
            }
            l++; r--;
        }
        return true;
    }

    public boolean isPalindromeInRange (int l, int r, String s) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++; r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "aba";
        String s2 = "abcbaa";
        ValidPalindromeII sol = new ValidPalindromeII();
        System.out.println(sol.validPalindrome(s2));
    }
}
