package com.haothink.leetcode.tree_breadth_first_search;

/**
 * Created by wanghao on 2021-04-17
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all
 * four edges of the grid are all surrounded by water.
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
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


    return 0;
  }

}
