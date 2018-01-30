/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example :

Input : [1 2]
Return :  1

 */
package DynamicProgramming;

import java.util.ArrayList;

public class BestTimeToBuyAndSellStocksI {
    public int maxProfit(final int[] A) {

        ArrayList<Integer> X = new ArrayList<Integer>(A.length);
        for (int i = 0; i < A.length; i++)
            X.add(Integer.valueOf(A[i]));


        if (X == null || X.size() == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;  //just remember the smallest price
        int profit = 0;
        for (int i : X) {
            min = i < min ? i : min;
            profit = (i - min) > profit ? i - min : profit;
        }

        return profit;

    }
}
