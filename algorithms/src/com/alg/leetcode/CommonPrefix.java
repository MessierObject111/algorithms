package com.alg.leetcode;

public class CommonPrefix {
    /**
     * For fuck's sake, I wrote this problem on Mar 4th 2021, merely 2.5 weeks ago, and I totally fucking forgot how did
     * I implement it in detail. I don't remember a thing about did I used a 'first' string as start.
     * @param strs
     * @return
     */
    public String commonPrefix (String[] strs) {
        if(strs.length < 1) return "";
        StringBuilder commonPrefix = new StringBuilder();
        String first = strs[0];
        for(int i = 0; i < first.length();i++) {
            char c = first.charAt(i);
            for(int j = 0; j < strs.length; j++) {
                if(i < strs[j].length()) {
                    if(strs[j].charAt(i) != c) {
                        return commonPrefix.toString();
                    }
                } else {
                    return commonPrefix.toString();
                }
            }
            commonPrefix.append(c);
        }

        return commonPrefix.toString();
    }

    public static void main(String[] args) {
        CommonPrefix sol = new CommonPrefix();
        String[][] input = {{""}, {"abc", "abd"}, {"abc", "def"}, {"abcd", "abc"}};
        for(int i = 0; i<input.length; i++){
            String result = sol.commonPrefix(input[i]);
            System.out.println(result);
        }

    }
}
