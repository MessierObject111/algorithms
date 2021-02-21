package com.alg.highFrequency;

/**1827. Number of Ways to Stay in the Same Place After Some Steps II
 * You have a pointer at index 00 in an array of size arrLenarrLen. At each step, you can move 11 position to the left,
 * 11 position to the right in the array or stay in the same place (The pointer should not be placed outside the array
 * at any time).

 Given two integers stepssteps and arrLenarrLen, return the number of ways such that your pointer still at index 00
 after exactly stepssteps steps.

 Since the answer may be too large, return it modulo 10^9 + 7

 1≤ steps ≤ 500
 1≤ arrLen ≤10^6
 ​​
 Example 1:

 Input:
 3
 2
 Output: 4
 Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
 Right, Left, Stay
 Stay, Right, Left
 Right, Stay, Left
 Stay, Stay, Stay
 Example 2:

 Input:
 2
 4
 Output: 2
 Explanation: There are 2 differents ways to stay at index 0 after 2 steps
 Right, Left
 Stay, Stay
 Example 3:

 Input:
 4
 2
 Output: 8
 ​​
 */
public class CombinationsToStayInPlace {

    // A: DFS Medium - Easy
    // B: DP Medium - Hard
    // C: Mathematical
    // D: BFS
    /**
     * @param steps: steps you can move
     * @param arrLen: the length of the array
     * @return: Number of Ways to Stay in the Same Place After Some Steps
     */
    public int numWays(int steps, int arrLen) {
        // write your code here
        return helperA(0, steps, arrLen);
    }

    /**
     * This method conducts a Depth-First-Search method to calculate
     * @param start
     * @param steps
     * @param arrLen
     * @return
     */
    private int helperA (int start, int steps, int arrLen) {
        if(start < 0 || start >= arrLen){
            return 0;
        }
        if (steps == 0) {
            if(start == 0) {
                return 1;
            }
            return 0;
        }
        return helperA(start - 1, steps - 1, arrLen) +
                helperA(start, steps - 1, arrLen) +
                helperA(start + 1, steps - 1, arrLen);
    }

    //This method uses Dynamic Programming to calculate
    private int helperB (){
        return helperB();
    }

    public static void main(String[] args) {
        CombinationsToStayInPlace ct = new CombinationsToStayInPlace();
        int result = ct.numWays(3, 2);
        System.out.println(result);
    }
}
