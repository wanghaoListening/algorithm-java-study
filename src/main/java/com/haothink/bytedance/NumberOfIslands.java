package com.haothink.bytedance;

/**
 * Created by wanghao on 2021/8/31
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 *Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 * 经典的dfs， 对每个节点进行dfs访问，将已经访问过的节点标记成已经访问过，这样以后dfs的时候就可以跳过，
 * 统计dfs的时候第一次遇到的陆地节点个数
 *
 *
 **/
public class NumberOfIslands {

  public static void main(String[] args) {

    char[][] grid = {
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}
    };

    NumberOfIslands numberOfIslands = new NumberOfIslands();

    System.out.println(numberOfIslands.numIslands(grid));

  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    int row = grid.length, columns = grid[0].length, count = 0;
    for (int i = 0; i < row; i++) {//遍历所有点
      for (int j = 0; j < columns; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j, row, columns);//dfs遍历所有连接的点
          count++;//记录岛屿数量
        }
      }
    }
    return count;
  }

  private void dfs(char[][] grid, int i, int j, int row, int columns) {
    if (i < 0 || j < 0 || i >= row || j >= columns || grid[i][j] == '0') return;//基线条件
    grid[i][j] = '0';//遍历过的点置 0
    dfs(grid, i + 1, j, row, columns);
    dfs(grid, i, j + 1, row, columns);
    dfs(grid, i - 1, j, row, columns);
    dfs(grid, i, j - 1, row, columns);
  }
}
