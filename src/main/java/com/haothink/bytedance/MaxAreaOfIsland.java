package com.haothink.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021/9/8
 *
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the
 * grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 **/
public class MaxAreaOfIsland {

  public static void main(String[] args) {

    int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
    MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();

    System.out.println(maxAreaOfIsland.maxAreaOfIsland(grid));
  }

  public int maxArea = 0;

  public int maxAreaOfIsland(int[][] grid) {

    if (grid == null || grid.length == 0) return 0;
    int row = grid.length, columns = grid[0].length;
    for (int i = 0; i < row; i++) {//遍历所有点
      for (int j = 0; j < columns; j++) {
        if (grid[i][j] == 1) {
          dfs(grid, i, j, row, columns,new ArrayList<>());//dfs遍历所有连接的点
        }
      }
    }
    return maxArea;
  }


  private void dfs(int[][] grid, int i, int j, int row, int columns, List<Integer> areaList) {
    if (i < 0 || j < 0 || i >= row || j >= columns || grid[i][j] == 0){
      if(areaList.size() > maxArea){
        maxArea = areaList.size();
      }
      return;//基线条件
    }
    grid[i][j] = 0;//遍历过的点置 0
    areaList.add(1);//面的加一
    dfs(grid, i + 1, j, row, columns,areaList);
    dfs(grid, i, j + 1, row, columns,areaList);
    dfs(grid, i - 1, j, row, columns,areaList);
    dfs(grid, i, j - 1, row, columns,areaList);
  }
}
