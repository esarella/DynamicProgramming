/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example :

Input : [1 2 3]
Return : 2

 */
package DynamicProgramming;

public class BestTimeToBuyAndSellStocksII {
    public static void main(String[] args) {

    }

    public int maxProfit(final int[] prices) {
        int n = prices.length;
        int maxProfit = 0;

        for (int i = 0; i < n - 1; i++) {
            if (prices[i + 1] > prices[i])
                maxProfit += prices[i + 1] - prices[i];
        }
        return maxProfit;
    }
}
