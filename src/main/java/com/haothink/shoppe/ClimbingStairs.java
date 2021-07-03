package com.haothink.shoppe;

/**
 * Created by wanghao on 2021-07-02
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 **/
public class ClimbingStairs {


  public static void main(String[] args) {

  }

  //Time Limit Exceeded
  public int climbStairs(int n) {

    if(n == 1){

      return 1;
    }
    if(n == 2){

      return 2;
    }
    if(n == 3){

      return 3;
    }

    return climbStairs(n-1) + climbStairs(n-2);
  }


  //this's ok
  public int climbStairs2(int n) {

    if(n == 1){

      return 1;
    }
    if(n == 2){

      return 2;
    }
    int temp = 0;
    int oneStair = 1;
    int twoStair = 2;

    int step = 3;
    while (step <= n){

      temp = twoStair;
      twoStair = oneStair + twoStair;
      oneStair = temp;
      step ++;
    }
    return twoStair;
  }

}
