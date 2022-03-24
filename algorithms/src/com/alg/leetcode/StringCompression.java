package com.alg.leetcode;

////////////////////////////////////////////////////////////////////
//                          _ooOoo_                               //
//                         o8888888o                              //
//                         88" . "88                              //
//                         (| ^_^ |)                              //
//                         O\  =  /O                              //
//                      ____/`---'\____                           //
//                    .'  \\|     |//  `.                         //
//                   /  \\|||  :  |||//  \                        //
//                  /  _||||| -:- |||||-  \                       //
//                  |   | \\\  -  /// |   |                       //
//                  | \_|  ''\---/''  |   |                       //
//                  \  .-\__  `-`  ___/-. /                       //
//                ___`. .'  /--.--\  `. . ___                     //
//              ."" '<  `.___\_<|>_/___.'  >'"".                  //
//            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
//            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
//      ========`-.____`-.___\_____/___.-`____.-'========         //
//                           `=---='                              //
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
//                  佛祖保佑       永不宕机     永无BUG              //
////////////////////////////////////////////////////////////////////

public class StringCompression {

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

    /**
     * When a sequence of same character ends, append based on rule. If more than 1, append char with number;
     * else just the char itself.
     * @param sb
     * @param c
     * @param count
     */
    private void smartAppend (StringBuilder sb, char c, int count) {
        String s = String.valueOf(c);
        if (count <= 1) {
            sb.append(s);
        } else {
            sb.append(s);
            sb.append(count);
        }
    }

    /**
     *
     * @param chars
     * @return
     */
    public int compress2nd(char[] chars) {
        if(chars.length < 2) return chars.length;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length - 1; i++) {
            int count = 1;
            sb.append(chars[i]);
            while(i < chars.length - 1 && chars[i] == chars[i + 1]) {
                System.out.println(i + " " + chars[i] + " count:" + count);
                count++;
                i++;
            }
            // Handling of last character
            if(i == chars.length - 1) {
                if(chars[i] != chars[i - 1]) {
                    if(count > 1) {
                        sb.append(count);
                    } else {
                        sb.append(chars[i]);
                    }
                }
            }
            if(count > 1) sb.append(count);
        }
        char[] altered = sb.toString().toCharArray();
        for(int i = 0; i < altered.length; i++) {
            chars[i] = altered[i];
        }

        return sb.toString().length();
    }

    public static void main(String[] args) {
        StringCompression solution = new StringCompression();
        String str_0 = "aabbcccccccccccccccccccccccdc";
        String str_1 = "abbccc";
        String str_2 = "aa";
        String str_3 = "abc";
        char[] input = str_3.toCharArray();
        int compressedLength = solution.compress2nd(input);


        for(int m = 0; m < compressedLength; m++) {
            String s = String.valueOf(input[m]);
            System.out.print(s);
        }
    }
}
