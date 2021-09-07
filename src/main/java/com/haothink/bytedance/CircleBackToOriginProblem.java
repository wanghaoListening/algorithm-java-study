package com.haothink.bytedance;

/**
 * Created by wanghao on 2021/9/7
 *
 * 0-12共13个数构成一个环，从0出发，每次走1步，走n步回到0共有多少种走法（2020.09 字节跳动-广告-后端） 0-8组成一个圆环，从0出发，每次可以逆时针和顺时针走，走n步能回到0有多少种情况（2020.09
 * 字节跳动-people-后端） 0~9的环，从0出发，N步后能否走回0。（2020.07 字节跳动-电商-后端） 圆环回原点问题 (2020.08 字节跳动-飞书-后端)
 *
 * 圆环上有10个点，编号为0~9。从0点出发，每次可以逆时针和顺时针走一步，问走n步回到0点共有多少种走法。
 *
 * 本题考察动态规划。经过分析可知：走n步到0的方案数=走n-1步到1的方案数+走n-1步到9的方案数。
 *
 * 动态规划
 **/
public class CircleBackToOriginProblem {

  public static void main(String[] args) {

    CircleBackToOriginProblem backToOriginProblem = new CircleBackToOriginProblem();

    System.out.println(backToOriginProblem.backToOrigin(10));
  }

  public int backToOrigin(int n) {
    int len = 10;
    int[][] dp = new int[n + 1][len];
    dp[0][0] = 1;
    for (int i = 1; i <= n; i++) {
      // 注意这里j 从 0 开始
      for (int j = 0; j < len; j++) {
        // dp[i][j]  ,  表示走i步回到j点有多少种走法
        dp[i][j] = dp[i-1][(j-1 + len) % len] + dp[i-1][(j+1) % len];
      }
    }
    return dp[n][0];
  }
}
