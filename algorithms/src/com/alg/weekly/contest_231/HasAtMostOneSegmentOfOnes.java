package com.alg.weekly.contest_231;
//Problem 1
public class HasAtMostOneSegmentOfOnes {
    public boolean checkOnesSegment(String s) {
        boolean exist = false;
        if(s.equals("1")) return true;
        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '1') {
                if(exist) {
                    return false;
                }
                int j = i;
                while(j < s.length() && s.charAt(j) == '1') {
                    j++;
                }
                i = j;
                exist = true;
            }
        }
        return exist;
    }

    public static void main(String[] args) {
        HasAtMostOneSegmentOfOnes sol = new HasAtMostOneSegmentOfOnes();
        String s1 = "10";
        System.out.println(sol.checkOnesSegment(s1));
    }
}
