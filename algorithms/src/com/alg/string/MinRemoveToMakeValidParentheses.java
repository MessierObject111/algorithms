package com.alg.string;

public class MinRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        if(s == null || s.length() == 0) return s;
        int count = 0;
        int removeCount = 0;
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
                } else {
                    removeCount++;
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
        for(int j = sb.length() - 1; j >= 0 && count < 0; j--) {
            char c = sb.charAt(j);
            if(c == ')') {
                sb.deleteCharAt(j);
                count++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MinRemoveToMakeValidParentheses sol = new MinRemoveToMakeValidParentheses();
        String result = sol.minRemoveToMakeValid("(a(b(c)d)");
        System.out.println(result);
    }
}
