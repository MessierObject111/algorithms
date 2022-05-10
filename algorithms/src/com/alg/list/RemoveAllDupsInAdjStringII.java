package com.alg.list;

public class RemoveAllDupsInAdjStringII {
    private boolean eligible = true; // The flag used to determine if another 'searchAndRemove' loop is needed

    public String removeDuplicates(String s, int k) {
        while(eligible) {
            String newString = searchAndRemove(s, k);
            s = newString;
        }
        return s;

    }

    private String searchAndRemove (String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        eligible = false;
        for(int i = 0, count = 0; i < s.length(); i++) {
            // When the count just started or adjacent chars do not equal to each other
            if(i == 0 || sb.charAt(i)!=sb.charAt(i - 1)){
                count = 1;//reset count to 1
            } // When the previous char is equal to current one and count reached k when including this one
            else if (sb.charAt(i)==sb.charAt(i - 1) && (count + 1) == k) {
                sb.delete(i + 1 - k, i + 1);// Delete the part where we found k duplicated adjacent chars.
                // Note here the start need to be i + 1 - k, end has to be i + 1
                eligible = true; // Mark for another searchAndRemove loop since we deleted portion of original string
                break; // Break the loop, start over again
            } // When the previous char is equal to current one and count didn't reached k yet when including this one
            else if (sb.charAt(i)==sb.charAt(i - 1)) {
                count++;
            }
        }
        return sb.toString();
    }

    // 2021-04-03 attempt:
    /* You need to either make your inner class static, or refer to it through an instance of the outer class.
    Most likely you just want to make your inner class static.

    Non-static members of a class (variables, methods, inner classes) are per instance of the class. Therefore,
    when accessing non-static members from a static context (such as a static method like testHashCodeOverride), you need
     to specify an instance of the enclosing class.*/
    static class AttemptII {
        boolean isEligible;
        public String removeDuplicates(String s, int k) {
            isEligible = true;
            StringBuilder sb = new StringBuilder(s);
            while(isEligible) {
                sb = removeDup(sb, k);
            }
            return sb.toString();
        }

        private StringBuilder removeDup(StringBuilder sb, int k) {
            isEligible = false;
            if(sb.length() < k) return sb;
            int i = 1;
            int count = 1;
            while(i < sb.length()) {
                if(sb.charAt(i - 1) == sb.charAt(i)) {
                    count++;
                    i++;
                    continue;
                } else {
                    if(count >= k) {
                        isEligible = true;
                        return sb.delete(i - count, i );
                    } else {
                        count = 1;
                    }
                }
                i++;
            }
            return sb;
        }
    }

    /**
     * 2022-03-21 Let's see how much I remember after a year...Probably nothing
     * I peeked into previous code structure a little bit
     * But still nowhere to solve it within 30 mins, it is totally fucked up
     * I make unbelievable typos like single '&' in conditional blocks
     * I wrote && instead of ||
     * I suffered from a zillion bugs & fixes
     *
     * //2022-03-22: For fuck's sake, leetcode added an extra long test case that made my previous passed solution
     * getting Time Limit Exceeded. The input string is as long as a damn novel
     */
    static class AttemptIII {
        public String removeDuplicates(String s, int k) {
            String result = removeAndConcat(s, k);
            return result;
        }

        private String removeAndConcat(String s, int k) {
            if(s.length() < k) return s;
            boolean needScan = true;
            while(needScan) {
                for(int i = 1, counter = 1; i < s.length(); i++)
                {
//                    System.out.println("Compare "+ s.charAt(i - 1) + " - " + s.charAt(i) + " , counter:" + counter);
                    if(s.charAt(i - 1) == s.charAt(i)) {
                        counter++;
                        if(counter == k) {
                            s = s.substring(0, i + 1 - k) + s.substring(i + 1);
//                            System.out.println(" concated: " + s);
                            needScan = true;
                            break;
                        }
                    }else if(s.charAt(i - 1) != s.charAt(i)){
                        counter = 1;
                        if(i == s.length()-1 || s.length() <= 1) {
                            needScan = false;
                        }
                    }
                }
                if(s.length() <= k) {
                    needScan = false;
                }
            }
            return s;
        }
    }


    public static void main(String[] args) {
        String input_1 = "abcccbbbc";//3 "abc"
        String input_2 = "aazaabbz";//2 ""
        String input_3 = "pbbcggttciiippooaais";//2 "ps"
        String input_4 = "deeedbbcccbdaa";
        String input_5 = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmn";


//        RemoveAllDupsInAdjStringII solution = new RemoveAllDupsInAdjStringII();
//        System.out.println("Test solution 1:");
//        System.out.println(solution.removeDuplicates(input_1, 3));
//        System.out.println(solution.removeDuplicates(input_2, 2));
//        System.out.println(solution.removeDuplicates(input_3, 2));
//
//        //Note: Solution 2 did not implement as problem required.
//        System.out.println("Test solution 2:");
//        RemoveAllDupsInAdjStringII.AttemptII sol2 = new AttemptII();
//        System.out.println(sol2.removeDuplicates(input_1, 3));
//
//        System.out.println(sol2.removeDuplicates(input_2, 2));
//        System.out.println(sol2.removeDuplicates(input_3, 2));
        //My logic will result to "is" as 3rd example's result, but it tells me it should be "ps" and I don't understand why
        // Note: 2022-03-21: The reason is the requirement is to immediately remove any know string that reaches k
        // repeating characters, rather than ALL the k+ repeating characters.
        // e.g removeDuplicates("aaab", 2) should return "ab" after removing first 2 'a's, rather than removing all 'a's

        System.out.println("Test solution 3:");
        RemoveAllDupsInAdjStringII.AttemptIII sol3 = new AttemptIII();
//        System.out.println(sol3.removeDuplicates(input_1, 3));
//        System.out.println(sol3.removeDuplicates(input_2, 2));
//        System.out.println(sol3.removeDuplicates(input_3, 2));
//        System.out.println(sol3.removeDuplicates(input_4, 3));
        System.out.println(sol3.removeDuplicates(input_5, 2));

//        String s = "0123456789";
//        System.out.println(s.substring(0,5));
//        System.out.println(s.substring(5));
//        s= s.substring(0,3) + s.substring(5);
//        System.out.println(s);
    }
}
