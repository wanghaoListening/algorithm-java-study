package com.haothink.tencent;

/**
 * Created by wanghao on 2021/8/16
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different
 * day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * 只需要遍历一次数组，用一个变量记录遍历过数中的最小值，然后每次计算当前值和这个最小值之间的差值最为利润，然后每次选较大的利润来更新。当遍历完成后当前利润即为所求
 **/
public class BestTimeToBuyAndSellStock {

  public static void main(String[] args) {

  }

  public int maxProfit(int[] prices) {

    if(prices.length <= 1) {
      return 0;
    }
    int minP = prices[0];
    int profit = prices[1] - prices[0];

    for(int i = 2; i < prices.length; i++) {
      minP = Math.min(prices[i-1], minP);
      profit = Math.max(profit, prices[i] - minP);
    }

    if(profit < 0) {
      return 0;
    }
    return profit;
  }
}
