package com.haothink.bytedance;

/**
 * Created by wanghao on 2021/9/8
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 * 动态规划只能应用于有最优 子结构的问题。最优子结构的意思是局部最优解能决定全局最优解
 * 简单地说，问题能够分解成子问题来解决。
 * 通俗一点来讲，动态规划和其它遍历算法（如深/广度优先搜索）都是将原问题拆成多个子问题然后求解，
 * 他们之间最本质的区别是，动态规划保存子问题的解，避免重复计算。
 *
 * 解决动态规划问题的关键是找到状态转移方程，这样我们可以通计算和储存子问题的解来求解最终问题。
 *
 * 同时，我们也可以对动态规划进行空间压缩，起到节省空间消耗的效果。
 * 动态规划是自下而上的，即先解决子问题，再解决父问题；
 *
 * dp[i][j] 表示从左上角开始到 (i, j) 位置的最
 *
 * 优路径的数字和。因为每次只能向下或者向右移动，我们可以很容易得到状态转移方程 dp[i][j] =
 *
 * min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
 *
 **/
public class MinimumPathSum {

  public static void main(String[] args) {

    MinimumPathSum minimumPathSum = new MinimumPathSum();
    int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
    System.out.println(minimumPathSum.minPathSum(grid));
  }

  public int minSum = Integer.MAX_VALUE;

  public int minPathSum(int[][] grid) {

    return minPathSumDp(grid);
  }

  //状态转义公式：dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
  public int minPathSumDp(int[][] grid) {
    if(grid == null || grid.length == 0 ) return 0;
    int m = grid.length, n = grid[0].length;
    int[][] dp = new int[m][n];
    dp[0][0] = grid[0][0];

    // 初始化行
    for(int i = 1; i < n; i++) {
      dp[0][i] = grid[0][i] + dp[0][i - 1];
    }

    // 初始化列
    for(int i = 1; i < m; i++) {
      dp[i][0] = grid[i][0] + dp[i - 1][0];
    }

    for(int i = 1; i < m; i++) {
      for(int j = 1; j < n; j++) {
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
      }
    }

    return dp[m - 1][n - 1];
  }

  //此方案Time Limit Exceeded
  public void dfs(int[][] grid,int sum,int row,int column){

    if(row == grid.length-1 && column == grid[0].length-1){
      if(sum < minSum){
        minSum = sum;
      }
    }
    if(row > grid.length-1 || column > grid[0].length-1){
      return;
    }

    if(row+1 <=grid.length-1) {
      dfs(grid, sum + grid[row + 1][column], row + 1, column);
    }
    if(column+1 <=grid[0].length-1) {
      dfs(grid, sum + grid[row][column + 1], row, column + 1);
    }
  }
}
