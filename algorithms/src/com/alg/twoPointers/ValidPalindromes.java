package com.alg.twoPointers;

public class ValidPalindromes {
    public boolean isPalindrome(String s) {
        if(s.length() < 2) return true;
        int left = 0, right = s.length() - 1;
        while (left <= right-1) {
            while(!isAlphaNumeric(s.charAt(left)) && left <= right - 1) {
                left++;
            }
            while(!isAlphaNumeric(s.charAt(right)) && left <= right - 1) {
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isAlphaNumeric (char c) {
        if (Character.isLetter(c) || Character.isDigit(c)) {
//            System.out.println("valid:" + c + ";");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPalindromes solution = new ValidPalindromes();
        String str_1 = "ab";
        System.out.println(solution.isPalindrome(str_1));

        String str_2 = "A man, a plan, a canal: Panama";
        System.out.println(solution.isPalindrome(str_2));

        String str_3 = "aa ,";
        System.out.println(solution.isPalindrome(str_3));

        String str_4 = "g";
        System.out.println(solution.isPalindrome(str_4));

        String str_5 = "vyv";
        System.out.println(solution.isPalindrome(str_5));
    }
}
