package com.practice.mediumalgo;

import java.util.Arrays;

public class MaximumProfitFromTradingStock {
    public int maximumProfit(int[] present, int[] future, int budget) {
        int len = present.length;
        int[][] stocks = new int[len][2];
        Integer[][] memo = new Integer[budget+1][len];

        for (int i = 0; i < len; i++) {
            stocks[i] = new int[]{present[i], future[i]-present[i]};
        }
        System.out.println(Arrays.deepToString(stocks));
        return maxProfitRecurse(stocks, budget, 0, memo);
    }

    /**
     * knapsack 0/1 recursive
     * @param stocks
     * @param rb     - remaining budget
     * @param ci     - current index
     * @return
     */
    private int maxProfitRecurse(int[][] stocks, int rb, int ci, Integer[][] memo) {
        //breaking condition
        if (ci >= stocks.length || rb<0) {
            return 0;
        }
        if (memo[rb][ci]!=null){
            System.out.printf("Memo hit: budget:%d, current index:%d.%n", rb, ci);
            return memo [rb][ci];
        }
        //use it
        int useItProfit = (stocks[ci][0]<=rb)?stocks[ci][1] + maxProfitRecurse(stocks, rb - stocks[ci][0], ci + 1, memo):0;
        System.out.printf("Current Index: %d, Remaining Budget: %d, UseItProfit: %d.%n", ci, rb, useItProfit);

        //or skip it
        int skipItProfit = maxProfitRecurse(stocks, rb, ci + 1, memo);
        System.out.printf("Current Index: %d, Remaining Budget: %d, SkipItProfit: %d.%n", ci, rb, skipItProfit);
        memo[rb][ci] = Math.max(useItProfit, skipItProfit);
        return memo[rb][ci];
    }

    /*
    Input: present = [5,4,6,2,3], future = [8,5,4,3,5], budget = 10
    Output: 6

    Input: present = [2,2,5], future = [3,4,10], budget = 6
    Output: 5
     */
    public static void main(String[] args){
        MaximumProfitFromTradingStock sol = new MaximumProfitFromTradingStock();
        System.out.println(sol.maximumProfit(new int[]{2,2,5}, new int[]{3,4,10}, 6));
        System.out.println(sol.maximumProfit(new int[]{5,4,6,2,3}, new int[]{8,5,4,3,5}, 10));
    }

}
