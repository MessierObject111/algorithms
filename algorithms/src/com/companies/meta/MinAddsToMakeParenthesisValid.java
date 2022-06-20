package com.companies.meta;

/**
 * 921. Minimum Add to Make Parentheses Valid
 * Medium
 *
 * 2627
 *
 * 149
 *
 * Add to List
 *
 * Share
 * A parentheses string is valid if and only if:
 *
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 *
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "())"
 * Output: 1
 * Example 2:
 *
 * Input: s = "((("
 * Output: 3
 */
public class MinAddsToMakeParenthesisValid {
    public int minAddToMakeValid(String s) {
        //Analysis: this is classic parenthesis problem. We just need to iterate through it once, and count how many 'unclosed'
        // left '(' and right ')' parenthesis, thus knowing how many additional parenthesis needed to close them up.
        // Let's keep tracking of how many unclosed left '('s we have by using an int balance = 0;
        // ..and keep tracking of how many total parenthesis we need to add to close up all unclosed parenthesis: int sum = 0;
        int sum = 0;
        int balance = 0;

        // In the start, if we saw unclosed ')'s, we know they cannot close itself even we read additional chars later, so we can
        // count themselves directly as 'need adds to make valid' into the sum whenever we see one;
        // If we see '(' from tart, then we can add them to balance temporarily, and keep reading to see if they get closed later.
        // This problem is basically asking for a logic analysis for all 4 cases of 2 variables when reading next char in string:
        // In each interation step,
        // 1. When bal >= 0 && nextChar == ')': bal--;
        // 2. When bal >= 0 && nextChar == '(': bal ++;
        // 3. When bal < 0 && nextChar == ')': sum++;
        // 4. When bal < 0 && nextChar == '(': bal++;


        for(int i = 0; i < s.length(); i++) {
            //After merging these logic into 2 nested if() blocks, we can get below aggregated code:
            if(s.charAt(i) == ')') {
                if(balance > 0) {
                    balance--;
                } else {
                    sum++;
                }
            } else {
                balance++;
            }
        }

        sum+=balance;

        return sum;
    }
}
