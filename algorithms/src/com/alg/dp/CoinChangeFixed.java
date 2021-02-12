package com.alg.dp;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeFixed {
    private static Map<Integer, Integer> resultCache = new HashMap<>();

    public int coinChange (int amount) {
        //Init status: $target dollars
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE - 1;
        if (resultCache.containsKey(amount)) {
            return resultCache.get(amount);
        }
        int minCount = getMinFrom(coinChange(amount - 7), coinChange(amount - 5), coinChange(amount - 2)) + 1;
        if(!resultCache.containsKey(amount) || resultCache.get(amount) > minCount) {
            resultCache.put(amount, minCount);
        }

        return minCount;
    }

    public int getMinFrom(int number1, int number2, int number3) {
        int temp = Integer.min(number1, number2);
        return Integer.min(temp, number3);
    }

    public static void main(String[] args) {
        CoinChangeFixed solution = new CoinChangeFixed();
        System.out.println("Num of Coin changes for 1: " + solution.coinChange(1));
//        System.out.println("Num of Coin changes for 2: " + solution.coinChange(2));
//        System.out.println("Num of Coin changes for 3: " + solution.coinChange(3));
//        System.out.println("Num of Coin changes for 4: " + solution.coinChange(4));
//        System.out.println("Num of Coin changes for 5: " + solution.coinChange(5));
//        System.out.println("Num of Coin changes for 6: " + solution.coinChange(6));
//        System.out.println("Num of Coin changes for 7: " + solution.coinChange(7));
//        System.out.println("Num of Coin changes for 8: " + solution.coinChange(8));
//        System.out.println("Num of Coin changes for 9: " + solution.coinChange(9));
//        System.out.println("Num of Coin changes for 27: " + solution.coinChange(27));//5+5+5+5+7
    }
}
