package com.alg.string;

public class MinRemoveToMakeValidParentheses {
    /**
     * I count excessive left parentheses from left to right in initial iteration, then based on the number of count,
     * we decide if a reverse iteration is needed to remove excessive '('s.
     * After iteration, count represents the total number of '(' minus total # of ')'s in string.
     * The initial iteration scenarios:
     * 1. current char is a left parentheses: count ++, append it to the new string
     * 2. current char is a right parentheses: we have to consider the number of left parentheses now. If the # of '('
     * is above zero, then we know this current placement of ')' is valid, so we make count-- and append it to new string;
     * if count is below zero, then it means we have more ')' than '(' already, and it is invalid, thus needing removal.
     * We then skip this ')' and not adding it to the new string.
     * 3.Current char is normal alphabet, then just append without updating count.
     *
     * After initial iteration, it is possible that we have more left parentheses than right parentheses (count>0)
     * We need then remove excessive '(' to restore its validity. We then iterate reverse and remove the first '(' we find.
     * @param s
     * @return
     */
    public String minRemoveToMakeValid(String s) {
        if(s == null || s.length() == 0) return s;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                sb.append(c);
                count++;
            } else if(c == ')') {
                if(count > 0) {
                    sb.append(c);
                    count--;
                }
            } else {
                sb.append(c);
            }
        }
        for(int j = sb.length() - 1; j >= 0 && count > 0; j--) {
            char c = sb.charAt(j);
            if(c == '(') {
                sb.deleteCharAt(j);
                count--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MinRemoveToMakeValidParentheses sol = new MinRemoveToMakeValidParentheses();
        String result = sol.minRemoveToMakeValid(")(a(b(c)d)");
        System.out.println(result);
    }
}
