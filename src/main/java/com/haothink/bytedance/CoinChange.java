package com.haothink.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by wanghao on 2021/9/4
 *
 * You are given an integer array coins representing coins of different denominations and
 * an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount
 * of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * [186,419,83,408]
 * 6249
 *
 * [1,2147483647]
 * 2
 * 
 *
 * 动态规划
 **/
public class CoinChange {


  public static void main(String[] args) {

    CoinChange coinChange = new CoinChange();

    int[] coins = {1,2147483647};int amount = 2;
    System.out.println(coinChange.coinChange(coins,amount));
  }


  public int coinChange_dp(int[] coins, int amount) {
    int n = coins.length;
    if(n == 0){
      return 0;
    }
    int dp[] = new int[amount + 1];
    for(int i = 1; i <= amount; ++i){
      dp[i] = Integer.MAX_VALUE;
      for(int j = 0; j < n; ++j){
        if(coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE){
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }
    if(dp[amount] == Integer.MAX_VALUE)
      return -1;
    else
      return dp[amount];
  }

  public int coinChange(int[] coins, int amount) {

    Arrays.sort(coins);
    TreeSet<Integer> result = new TreeSet<>();
    dfs(coins,amount,0,result);
    return result.isEmpty()?-1:result.first();

  }

  public void dfs(int[] coins,int amount,int number,Set<Integer> result){

    if(amount < 0){
      return;
    }
    if(amount == 0){
      result.add(number);
      return;
    }
    for(int i=coins.length-1;i>=0;i--){

      dfs(coins,amount-coins[i],number+1,result);
    }
  }
}
