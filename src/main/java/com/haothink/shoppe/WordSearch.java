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
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 **/
public class WordSearch {


  public static void main(String[] args) {


  }

  public boolean exist(char[][] board, String word) {

    List<Position> firstLetterPositionList = new ArrayList<>();

    char ch = word.charAt(0);



    return false;
  }


  public static class Position{

    public int row;
    public int column;

    public Position(int row, int column) {
      this.row = row;
      this.column = column;
    }
  }
}
