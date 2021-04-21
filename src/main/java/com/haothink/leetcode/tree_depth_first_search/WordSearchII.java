package com.haothink.leetcode.tree_depth_first_search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021-04-20
 *
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
 * vertically neighboring. The same letter cell may not be used more than once in a word.
 **/
public class WordSearchII {


  public static void main(String[] args) {

  }

  public List<String> findWords(char[][] board, String[] words) {

    List<String> wordList = new ArrayList<>();
    for(String word : words){

      boolean result = dfsFindChar(board,0,0,word);
      if(result){
        wordList.add(word);
      }
    }

    return wordList;
  }

  private boolean dfsFindChar(char[][] board,int row,int column,String word){



    return false;
  }
}
