package com.alg.dp;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    private static Map<Integer, Integer> resultCache = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if (resultCache.containsKey(amount)) {
            return resultCache.get(amount);
        }
        int[] temp = new int[coins.length];
        for(int i = 0; i < coins.length; i++) {
            int minSteps = coinChange(coins, amount - coins[i]);
            if(minSteps != -1) {
                temp[i] = minSteps + 1;
            } else {
                temp[i] = -1;
            }

        }
        int result = getMin(temp);

        if(!resultCache.containsKey(amount) || resultCache.get(amount) > result) {
            resultCache.put(amount, result);
        }
        return result;
    }

    public int getMin(int[] inputArray){
        int minValue = Integer.MAX_VALUE - 1;
        boolean foundMinCombo = false;
        for(int i = 0; i < inputArray.length; i++) {
            if(inputArray[i] == -1) {
                continue;
            }
            foundMinCombo = true;
            if(inputArray[i] < minValue){
                minValue = inputArray[i];

            }
        }
        if(!foundMinCombo) {
            return -1;
        }
        return minValue;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        CoinChange s = new CoinChange();
        int[] changes = {2,5,7};

//        System.out.println("Num of Coin changes for 1: " + s.coinChange(changes, 1));
//        System.out.println("Num of Coin changes for 2: " + s.coinChange(changes, 2));
//        System.out.println("Num of Coin changes for 3: " + s.coinChange(changes, 3));
//        System.out.println("Num of Coin changes for 4: " + s.coinChange(changes, 4));
//        System.out.println("Num of Coin changes for 5: " + s.coinChange(changes, 5));
//        System.out.println("Num of Coin changes for 6: " + s.coinChange(changes, 6));
//        System.out.println("Num of Coin changes for 7: " + s.coinChange(changes, 7));
//        System.out.println("Num of Coin changes for 8: " + s.coinChange(changes, 8));
//        System.out.println("Num of Coin changes for 9: " + s.coinChange(changes, 9));
        System.out.println("Num of Coin changes for 27: " + s.coinChange(changes, 27));//5+5+5+5+7
//        System.out.println("Num of Coin changes: " + s.coinChange(changes, 100));

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
