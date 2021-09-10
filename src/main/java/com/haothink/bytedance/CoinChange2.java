package com.haothink.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021/9/8
 *
 * You are given an integer array coins representing coins of different denominations and an
 * integer amount representing a total amount of money.
 *
 * Return the number of combinations that make up that amount. If that amount of money cannot
 * be made up by any combination of the coins, return 0.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * The answer is guaranteed to fit into a signed 32-bit integer.
 *
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 *
 * dp[i][j] 表示用前i个硬币组成钱数为j的不同组合方法
 *
 * 结果需待改正，
 * 动态规划
 **/
public class CoinChange2 {

  public static void main(String[] args) {

    CoinChange2 coinChange2 = new CoinChange2();
    int[] coins = {1,2,5};
    int amount = 5;
    System.out.println(coinChange2.change(amount,coins));
  }
  public int count = 0;

  public int changeDfs(int amount, int[] coins) {

    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins)
      for (int i = 0; i <= amount - coin; ++i)
        dp[i + coin] += dp[i];
    return dp[amount];
  }

  public int change(int amount, int[] coins) {

    dfs(coins,amount,new ArrayList<>());
    return count;
  }

  public void dfs(int[] coins,int amount, List<Integer> result){

    if(amount < 0){
      return;
    }
    if(amount == 0){
      count ++;
      System.out.println(result);
      return;
    }
    for(int i=0;i<coins.length;i++){

      List<Integer> newResult = new ArrayList<>(result);
      newResult.add(coins[i]);
      dfs(coins,amount-coins[i],newResult);
    }
  }
}
