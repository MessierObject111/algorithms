package com.alg.weekly.contest_232;
//Problem1
//Check if One String Swap Can Make Strings Equal
public class CheckIfOneStringSwapCanMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int i = 0;
        while(i < n && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        if(i >= n) return true;
        int j = i + 1;
        while(j < n && s1.charAt(j) == s2.charAt(j)) {
            j++;
        }
        if(j >= n) return false;
        StringBuilder sb1 = new StringBuilder(s1);
        char c1 = s1.charAt(i);
        char c2 = s1.charAt(j);
        sb1.setCharAt(i, c2);
        sb1.setCharAt(j, c1);
        String swappedS1 = sb1.toString();
        if(swappedS1.equals(s2)) {
            return true;
        }
        return false;
        // abcc acbc - t
        // xabc yabc - f
        // aaa aab - f
        //"kelb" "kelb"
    }

    public static void main(String[] args) {
        CheckIfOneStringSwapCanMakeStringsEqual s = new CheckIfOneStringSwapCanMakeStringsEqual();
        boolean result = s.areAlmostEqual("aa", "bb");
        System.out.println(result);
    }
}
