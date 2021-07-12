package com.haothink.shoppe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021-07-11
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
 * horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Input: board = [["A","B","C","E"],
 *                 ["S","F","C","S"],
 *                 ["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * 基本的做法就是对每个位置尝试所有的可能， 因为这里要递归做并且每个位置都只能用一次，所以要backtrack， 用一个visited表示当前位置是否已经用过
 *
 * 经典：backtrack
 **/
public class WordSearch {


  public static void main(String[] args) {


  }

  public boolean exist(char[][] board, String word) {
    for(int i = 0; i < board.length; ++i) {
      for(int j = 0; j < board[i].length; ++j) {
        boolean[][] visited = new boolean[board.length][board[i].length];
        if(backtrack(board, i, j, 0, word, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean backtrack(char[][] board, int i, int j, int index, String word, boolean[][] visited) {
    if(index == word.length()) return true;
    if(i < 0 || i >= board.length || j < 0 || j >= board[i].length) return false;
    if(visited[i][j] || board[i][j] != word.charAt(index)) return false;

    visited[i][j] = true;
    if(backtrack(board, i+1, j, index+1, word, visited)
        || backtrack(board, i-1, j, index+1, word, visited)
        || backtrack(board, i, j+1, index+1, word, visited)
        || backtrack(board, i, j-1, index+1, word, visited)
    ) {
      return true;
    }
    visited[i][j] = false;
    return false;
  }
}
