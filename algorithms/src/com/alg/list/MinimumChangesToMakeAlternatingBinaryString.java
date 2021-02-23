package com.alg.list;

/**
 * 1758. Minimum Changes To Make Alternating Binary String
 * User Accepted:4719
 * User Tried:5254
 * Total Accepted:4922
 * Total Submissions:8574
 * Difficulty:Easy
 * You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.
 *
 * The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.
 *
 * Return the minimum number of operations needed to make s alternating.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "0100"
 * Output: 1
 * Explanation: If you change the last character to '1', s will be "0101", which is alternating.
 * Example 2:
 *
 * Input: s = "10"
 * Output: 0
 * Explanation: s is already alternating.
 * Example 3:
 *
 * Input: s = "1111"
 * Output: 2
 * Explanation: You need two operations to reach "0101" or "1010".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s[i] is either '0' or '1'.
 */
public class MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        if(s.length() <= 1) {
            return 0;
        }
        int count1 = 0;
        int current = s.charAt(0) - '0';
        for(int i = 1; i < s.length(); i++) {
            if(current == s.charAt(i) - '0') {
                count1++;
            }
            current = current == 0 ? 1 : 0;
        }
        int count2 = 1;
        current = s.charAt(0) - '0';
        current = current == 0 ? 1 : 0;
        for(int i = 1; i < s.length(); i++) {
            if(current == s.charAt(i) - '0') {
                count2++;
            }
            current = current == 0 ? 1 : 0;
        }
        return Math.min(count1, count2);
    }
}
