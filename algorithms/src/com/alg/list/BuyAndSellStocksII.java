package com.alg.list;

public class BuyAndSellStocksII {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int sum = 0;
        int buyPrice = -1;

        for(int i = 0; i < prices.length; i++) {

            if((i == 0)){
                if(prices[i] < prices[i+1]) buyPrice = prices[i];
                continue;
            }
            if(i == prices.length-1) {
                if(prices[i-1] < prices[i] && buyPrice >= 0) {
                    int sellPrice = prices[i];
                    sum += (sellPrice - buyPrice);
                }
                continue;
            }

            if(prices[i-1] >= prices[i] && prices[i] < prices[i+1]) {
                buyPrice = prices[i];
            }

            if(prices[i-1] < prices[i] && prices[i] >= prices[i+1]) {
                int sellPrice = prices[i];
                sum += (sellPrice - buyPrice);
                buyPrice = -1;
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        BuyAndSellStocksII s = new BuyAndSellStocksII();
        int[] stocks_1 = {7,1,5,3,6,4};
        System.out.println(s.maxProfit(stocks_1));
    }

}
