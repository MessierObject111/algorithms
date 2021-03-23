package com.alg.list;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {
    /**
     * 2021-03-19: First attempt is a failure. This will not provide the correct answer for some cases.
     * Why is it wrong? It ignored the case when same char appears multiple times and sequence could come after that.
     * abcdfed
     * abcfed
     * This method will come to conclusion that abcd is the longest common sub sequence, instead of abcfed
     * @param text1
     * @param text2
     * @return
     */
//    public int longestCommonSubsequence_Failed(String text1, String text2) {
//        if(text1.length() == 0 || text2.length() == 0) return 0;
//        int maxLength = 0;
//        for(int k = 0 ; k < text1.length(); k++) {
//            int start = 0;
//            StringBuilder commonSubSeq = new StringBuilder();
//
//            for(int i = k; i < text1.length(); i++) {
//                char c = text1.charAt(i);
//
//                for(int j = start; j < text2.length(); j++) {
//                    if(c == text2.charAt(j)) {
//                        start = j + 1;
//                        commonSubSeq.append(c);
//                        break;
//                    }
//                }
//            }
//            int length = commonSubSeq.length();
//            maxLength = length > maxLength ? length : maxLength;
//            System.out.println(commonSubSeq);
//        }
//
//        return maxLength;
//    }


    /**
     * 2021-03-21: After reading failed test cases and solutions, I realized previous mistake on approach. This problem
     * can only be solved by DP: adbcd - abcd, for example, by lopping & comparing, we can only get 'ad' as the longest
     * common subsequence; but by tearing it down to smaller problems with DB, we can come up with a 2D array of t1 & t2
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if(len1 < 0 || len2 < 0) return 0;
        Integer[][] dp = new Integer[len1][len2];
        return recurse(text1, text2, len1-1, len2-1, dp);
    }

    public int recurse(String text1, String text2, int len1, int len2, Integer[][] dp) {
        if(len1 < 0 || len2 < 0) return 0;
        if(dp[len1][len2] != null) return dp[len1][len2];
        if(text1.charAt(len1) == text2.charAt(len2)) {
            int count = 1 + recurse(text1, text2, len1 - 1, len2 - 1, dp);
            dp[len1][len2] = count;
            return count;
        } else {
            int max = Math.max(recurse(text1, text2, len1, len2 - 1, dp),
                    recurse(text1, text2, len1 - 1, len2, dp));
            return dp[len1][len2] = max;
        }
    }



    public static void main(String[] args) {
        LongestCommonSubsequence sol = new LongestCommonSubsequence();
//        String text1 = "oxcpqrsvwf";
//        String text2 = "shmtulqrypy";

//        String text1 = "xaby";
//        String text2 = "yabx";

        String text1 = "mhunuzqrkzsnidwbun";
        String text2 = "szulspmhwpazoxijwbq"; //Expect 6
//        m	s
//        h	z
//        u	u
//        n	l
//        u	s
//        z	p
//        q	m	6
//        r	h	5
//        k	w
//        z	p
//        s	a
//        n	z	4
//        i	o
//        d	x
//        w	i	3
//        b	j
//        u	w	2
//        n	b	1
//        q

        char c = 'z';
        String sb = new String(text1);
        System.out.println(sb + c);

        System.out.println(sol.longestCommonSubsequence(text1, text2));

    }
}
