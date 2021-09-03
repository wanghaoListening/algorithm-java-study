package com.haothink.bytedance;

/**
 * Created by wanghao on 2021/9/2
 *
 * Given an m x n binary matrix filled with 0's and 1's, find the largest
 * square containing only 1's and return its area.
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 *
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 *
 * 一般求解最值的问题都可以朝着动态规划的方向去想。
 * 解题思路
 * https://leetcode-cn.com/problems/maximal-square/solution/221-zui-da-zheng-fang-xing-tu-jie-shi-pin-yan-shi-/
 *
 * 定义：dp[i][j]dp[i][j]表示以第i行和j列为右下角的正方形的最大边长。
 *
 **/
public class MaximalSquare {


  public int maximalSquare(char[][] matrix) {

    int maxSide = 0;
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return maxSide;
    }
    int rows = matrix.length, columns = matrix[0].length;
    int[][] dp = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (matrix[i][j] == '1') {
          if (i == 0 || j == 0) {
            dp[i][j] = 1;
          } else {
            dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
          }
          maxSide = Math.max(maxSide, dp[i][j]);
        }
      }
    }
    return maxSide * maxSide;
  }
}
