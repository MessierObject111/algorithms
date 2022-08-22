package com.companies.amazon.oa;

public class MaxDeviationInAllSubString {
    public int largestVariance(String s) {

        int [] freq = new int[26];
        //Iterate each char in string s, count each letter's frequency in a dictionary: int[26] freq
        //freq[0] is frequency of 'a'; freq[1] is frequency of 'b'
        for(int i = 0 ; i < s.length() ; i++)
            freq[(int)(s.charAt(i) - 'a')]++;

        int maxVariance = 0;
        for(int a = 0 ; a < 26 ; a++){
            for(int b = 0 ; b < 26 ; b++){
                int remainingA = freq[a];
                int remainingB = freq[b];
                // If there are no more remaining A/B, leave this loop and reset A&B freq values;
                if(a == b || remainingA == 0 || remainingB == 0) continue;

                // run Kadane's algorithm on each possible character pairs (A & B)
                // Kadane's algo:
                // https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d
                // localMaximum[i] = Math.max(A[i] + local_maximum[i-1])
                int currBFreq = 0, currAFreq = 0;
                for(int i = 0 ; i < s.length() ; i++){
                    //Note the c value here is the RELATIVE value of the letter's order in the 26 alphabet, not the real
                    //ASC II value: lowercase a' has ASC II value 97, and 'b' == 98, ... 'z' == 122.
                    // For example, 'c' == 99, but 'c' - 'a' = 99-97 = 2
                    int c =  (int)(s.charAt(i) - 'a');

                    if(c == b) currBFreq++;
                    if(c == a) {
                        currAFreq++;
                        remainingA--;
                    }

                    // Key logic of Kadane's Algorithm: localMaximum[i] = Math.max(A[i] + local_maximum[i-1])
                    if(currAFreq > 0)
                        maxVariance = Math.max(maxVariance, currBFreq - currAFreq);

                    // If current B freq < A freq, also leave the loop -
                    if(currBFreq < currAFreq &&  remainingA >= 1){
                        currBFreq = 0;
                        currAFreq = 0;
                    }
                }
            }
        }

        return maxVariance;
    }

    public static void main(String[] args) {
        MaxDeviationInAllSubString sol = new MaxDeviationInAllSubString();
        String test1 = "bbacccabab";
        System.out.println(sol.largestVariance(test1));//expect 2

    }
}
