package com.haothink.bytedance;

/**
 * Created by wanghao on 2021/9/11
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Input: m = 3, n = 7
 * Output: 28
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * 
 * 动态规划
 **/
public class UniquePaths {

  public static void main(String[] args) {

    UniquePaths uniquePaths = new UniquePaths();

    System.out.println(uniquePaths.uniquePaths(3,7));
  }

  public int uniquePaths(int m, int n) {

    int[][] dp = new int[m][n];
    //left column
    for(int i=0; i<m; i++){
      dp[i][0] = 1;
    }

    //top row
    for(int j=0; j<n; j++){
      dp[0][j] = 1;
    }
    for(int i=1;i<m;i++){
      for(int j=1;j<n;j++){

        dp[i][j] = dp[i][j-1] + dp[i-1][j];
      }
    }
    return dp[m-1][n-1];
  }

}
