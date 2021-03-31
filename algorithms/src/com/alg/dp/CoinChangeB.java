package com.alg.dp;

public class CoinChangeB {
    /**
     * 2021-03-28
     * I wrote this again after the day I give another MSI candidate this question in mock interview. I couldn't write
     * this out during the 30min in the interview, so I did it afterwards -- And I found myself couldn't remember
     * details last time I implemented it a week or two back.
     * A week after that, I sit down and thought this in quiet night -- And I did it again without checking answers.
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[coins.length];
        int minCount = 1 + recurse(coins, amount, dp);
        return minCount;
    }

    private int recurse(int[] coins, int amount, int[] dp) {
        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return -1;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        } else {
            int[] stepsArr = new int[coins.length];
            for(int i = 0; i < coins.length; i++){
                int distance = recurse(coins, amount - coins[i], dp);
                stepsArr[i] = distance == -1 ? Integer.MAX_VALUE : 1 + distance;
                if(dp[amount] == 0 || dp[amount] > stepsArr[i]) {
                    dp[amount] = stepsArr[i];
                }
            }
            return min(stepsArr);
        }

    }

    private int min(int[] arr) {
        int MIN = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < MIN) {
                MIN = arr[i];
            }
        }
        return MIN;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        CoinChange s = new CoinChange();
        int[] changes = {2,5, 7};

        System.out.println("Num of Coin changes for 1: " + s.coinChange(changes, 1));
        System.out.println("Num of Coin changes for 2: " + s.coinChange(changes, 2));
        System.out.println("Num of Coin changes for 3: " + s.coinChange(changes, 3));
        System.out.println("Num of Coin changes for 4: " + s.coinChange(changes, 4));
        System.out.println("Num of Coin changes for 5: " + s.coinChange(changes, 5));
        System.out.println("Num of Coin changes for 6: " + s.coinChange(changes, 6));
        System.out.println("Num of Coin changes for 7: " + s.coinChange(changes, 7));
        System.out.println("Num of Coin changes for 8: " + s.coinChange(changes, 8));
        System.out.println("Num of Coin changes for 9: " + s.coinChange(changes, 9));
        System.out.println("Num of Coin changes for 27: " + s.coinChange(changes, 27));//5+5+5+5+7
//        System.out.println("Num of Coin changes: " + s.coinChange(changes, 100));

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
