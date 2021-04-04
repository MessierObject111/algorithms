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


    public static void main(String[] args) {
        String input_1 = "abcccbbbc";
        String input_2 = "aazaabbbbbz";
        String input_3 = "pbbcggttciiippooaais";//"ps" "is"

        RemoveAllDupsInAdjStringII solution = new RemoveAllDupsInAdjStringII();
        System.out.println(solution.removeDuplicates(input_1, 3));

        RemoveAllDupsInAdjStringII.AttemptII sol2 = new AttemptII();
        System.out.println(sol2.removeDuplicates(input_1, 3));

        System.out.println(sol2.removeDuplicates(input_2, 3));
        System.out.println(sol2.removeDuplicates(input_3, 2));
        //My logic will result to "is" as 3rd example's result, but it tells me it should be "ps" and I don't understand why
    }
}
