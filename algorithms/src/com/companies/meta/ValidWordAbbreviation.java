package com.companies.meta;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        int total = 0;
        while(j < abbr.length()) {
            if(Character.isDigit(abbr.charAt(j))) {
                if(abbr.charAt(j) == '0') return false;
                int end = j;
                while(end < abbr.length() && Character.isDigit(abbr.charAt(end))){
                    end++;
                }
                String subStr = abbr.substring(j, end);
                int steps = Integer.valueOf(subStr);

                j = end; //The index for abbr should be the length of the digits of numbers, e.g. 3 for '443', 2 for '15', 1 for '9'
                i += steps;//The index for actual string before abbrevation should be index1 + steps
                total += steps;
                System.out.println("Steps over:" + steps + " index 1:" + i+ " index 2:" + j );
            } else {
                if(i < word.length() && (j < abbr.length())) {

                    System.out.println("Steppped; index1:" + i + " index2:"+ j+ " char 1:" + word.charAt(i) +" char 2:"+ abbr.charAt(j) );
                    if (word.charAt(i) != abbr.charAt(j)) {
                        return false;
                    }
                    i++;
                    j++;
                    total++;
                }
                if ((i >= word.length() && j < abbr.length()) || (j >= abbr.length() && i < word.length())){
                    return false;
                }

            }
            //Now, we have the steps to move in original word.
        }
        return total == word.length();
    }

    //https://leetcode.com/problems/valid-word-abbreviation/discuss/89523/Short-and-easy-to-understand-Java-Solution
    public boolean validWordAbbreviationII(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;++j;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                ++j;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }
        return i == word.length() && j == abbr.length();
    }


    public static void main(String[] args) {
        ValidWordAbbreviation sol = new ValidWordAbbreviation();
        String s1 = "hi";
        String s2 = "2i";
        System.out.println(sol.validWordAbbreviation(s1, s2));//false

        System.out.println(sol.validWordAbbreviation(
                "internationalization",
                "i12iz4n")); //true
        
    }
}
