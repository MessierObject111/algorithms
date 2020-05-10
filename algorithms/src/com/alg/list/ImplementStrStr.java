package com.alg.list;

/**
 * For a given source string and a target string, you should output the first index(from 0) of target string in source string.
 *
 * If target does not exist in source, just return -1.
 * Clarification
 * Do I need to implement KMP Algorithm in a real interview?
 *
 * Not necessary. When you meet this problem in a real interview, the interviewer may just want to test your basic implementation ability. But make sure you confirm with the interviewer first.
 * Example
 * Example 1:
 *
 * Input: source = "source" ，target = "target"
 * Output: -1
 * Explanation: If the source does not contain the target content, return - 1.
 * Example 2:
 *
 * Input:source = "abcdabcdefg" ，target = "bcd"
 * Output: 1
 * Explanation: If the source contains the target content, return the location where the target first appeared in the source.
 * Challenge
 * O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)
 */
public class ImplementStrStr {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public int strStr(String source, String target) {
        //write your code here
        if( source == null || target == null){
            return -1;
        }
        int srcLength = source.length();
        int tarLength = target.length();

        if(tarLength == 0){
            return 0;
        }

        if( srcLength == 0 && tarLength != 0){
            return -1;
        }

        if(srcLength >= tarLength){
            for(int i = 0; i <= srcLength - tarLength; i++){
                if(source.charAt(i) == target.charAt(0)){
                    //System.out.println("Found same char: "+ source.charAt(i) +" at "+i);
                    int inner_pointer = i, j = 0;
                    while(j <= tarLength && source.charAt(inner_pointer) == target.charAt(j)){
                        j++;
                        inner_pointer++;
                        if(j == tarLength){
                            return inner_pointer - j;
                        }
                    }
                    // If function did not return, and executed here
                }
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        ImplementStrStr instance = new ImplementStrStr();
        String source = "adedaaaefg";
        String target = "aaae";
        System.out.println(instance.strStr(source, target));

        Boolean bigB = true;
        boolean bool = bigB == null ? false : true;
        if(bool) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
