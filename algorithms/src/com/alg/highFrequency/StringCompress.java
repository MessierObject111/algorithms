package com.alg.highFrequency;

/**
 * 213. 字符串压缩
 * 设计一种方法，通过给重复字符计数来进行基本的字符串压缩。
 *
 * 例如，字符串 aabcccccaaa 可压缩为 a2b1c5a3 。而如果压缩后的字符数不小于原始的字符数，则返回原始的字符串。
 *
 * 可以假设字符串仅包括 a-z 的字母。
 *
 * 样例
 * 样例 1：
 *
 * 输入：str = "aabcccccaaa"
 * 输出："a2b1c5a3"
 * 样例 2：
 *
 * 输入：str = "aabbcc"
 * 输出："aabbcc"
 */
public class StringCompress {
    public static String compress(String originalString) {
        // write your code here
        if(originalString.length() <= 2) return originalString;

        int originalLength = originalString.length();
        char current = originalString.charAt(0);
        StringBuilder result = new StringBuilder(current);
        int count = 1;

        for(int i = 1; i < originalLength; i++) {

            char temp = originalString.charAt(i);
            if (temp == current) {
                count++;
            } else {
                result.append(current).append(count);
                current = temp;
                count = 1;
            }
            if(i == originalLength - 1) {
                result.append(temp).append(count);
            }
        }

        return result.toString().length() >= originalLength ? originalString : result.toString();
    }

    public static void main(String[] args) {
        String input = "aabcccccaaa";
        System.out.println(compress(input));
        System.out.println('a' == input.charAt(0));

//        String input2 = "1234567";
//        StringBuilder sb = new StringBuilder(input2);
//        sb.replace(0,1, "-");
//
//        System.out.println(sb);
//        System.out.println(sb.charAt(6));
    }
}
