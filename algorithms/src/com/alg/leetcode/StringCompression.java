package com.alg.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class StringCompression {
    char[] chars;
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int i = 1;
        if(chars.length == 1) return 1;
        Character existing = chars[0];
        while(i <= chars.length) {
            if(i == chars.length) {
                smartAppend(sb, chars[i-1], count);
                break;
            } else {
                Character current = chars[i];
                if(existing.equals(current)) {
                    count++;
                } else {
                    smartAppend(sb, chars[i-1], count);
                    existing = chars[i];
                    count = 1;
                }
                i++;
            }
        }
        // Modified the input array to new array here
//        chars = sb.toString().toCharArray();

        for(int m = 0; m < sb.length(); m++) {
            Character c = sb.charAt(m);
            chars[m] = c;
        }
        return sb.length();
    }

    private void smartAppend (StringBuilder sb, char c, int count) {
        String s = String.valueOf(c);
        if (count <= 1) {
            sb.append(s);
        } else {
            sb.append(s);
            sb.append(count);
        }
    }

    public AtomicInteger add(AtomicInteger i) {
        i.addAndGet(1);
        return i;
    }

    public static void main(String[] args) {
        StringCompression solution = new StringCompression();
        String str_0 = "aabbcccccccccccccccccccccccdc";
        char[] input = str_0.toCharArray();
        System.out.println(solution.compress(input));

        AtomicInteger number = new AtomicInteger(0);
        solution.add(number);
        System.out.println(number);

        for(int m = 0; m < input.length; m++) {
            String s = String.valueOf(input[m]);
            System.out.print(s);
        }
    }
}
