package com.haothink.bytedance;

/**
 * Created by wanghao on 2021/10/14
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any
 * profit, return 0.
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 **/
public class BestTimeToBuyAndSellStock {


  public int maxProfit(int[] prices) {

    if(null == prices || prices.length <=0){
      return 0;
    }

    int minP = prices[0];
    int price = prices[1] - prices[0];

    for(int i=2;i<prices.length;i++){

      minP = Math.min(prices[i-1],minP);
      price = Math.max(prices[i] - minP,price);
    }

    if(price < 0) {
      return 0;
    }
    return price;
  }
}
