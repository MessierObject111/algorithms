package com.alg.list;

/**
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 *
 * For the purpose of this problem, we define empty string as valid palindrome.
 * Example
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama"
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 * Explanation: "raceacar"
 * Challenge
 * O(n) time without extra memory.
 */
public class ValidPalindrome {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;
        boolean isPalindrome;
        int start = 0, end = s.length() - 1;
        while(start + 1 < end) {
            char c1 = Character.toLowerCase(s.charAt(start));
            char c2 = Character.toLowerCase(s.charAt(end));
            while ( !isValid(c1) && start + 1 < end) {
                start++;
                c1 = Character.toLowerCase(s.charAt(start));
            }
            while ( !isValid(c2) && start + 1 < end) {
                end--;
                c2 = Character.toLowerCase(s.charAt(end));
            }
            if ((c1) != (c2)) {
                isPalindrome = false;
                return isPalindrome;
            }
            start++;
            end--;
        }

        if(start == end) {
            isPalindrome = true;
        } else {
            char c1 = Character.toLowerCase(s.charAt(start));
            char c2 = Character.toLowerCase(s.charAt(end));
            if(!isValid(c1) || !isValid(c2)) {
                isPalindrome = true;
            } else {
                isPalindrome = c1 == c2;
            }
        }
        return isPalindrome;
    }

    private boolean isValid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

    public static void main(String[] args) {
        ValidPalindrome instance = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        String s2 = "1b 1";
        System.out.println(instance.isPalindrome(s2));
    }
}
