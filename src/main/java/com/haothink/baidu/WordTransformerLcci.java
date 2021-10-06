package com.haothink.baidu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wanghao on 2021/10/6
 *
 * 给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。
 *
 * 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出:
 * ["hit","hot","dot","lot","log","cog"]
 *
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: []
 *
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 *
 *
 *
 **/
public class WordTransformerLcci {



  public static void main(String[] args) {

    String beginWord = "hit";
    String endWord = "cog";
    //String[] wordList = {"hot","dot","dog","lot","log"};
    List<String> wordList = new ArrayList<>();
    wordList.add("hot");
    wordList.add("dot");
    wordList.add("dog");
    wordList.add("lot");
    wordList.add("log");
    wordList.add("cog");

    WordTransformerLcci wordTransformerLcci = new WordTransformerLcci();

    System.out.println(wordTransformerLcci.findLadders(beginWord,endWord,wordList));

  }

  List<String> res = new ArrayList<>();
  boolean isFind = false;

  //采用dfs
  public List<String> findLadders(String beginWord,String endWord,List<String> wordList){

    List<String> resultList = new ArrayList<>();
    //不含结束词,直接返回
    if(!wordList.contains(endWord)) return resultList;

    dfs(beginWord,endWord,wordList,resultList,new boolean[wordList.size()]);
    return res;
  }

  public void dfs(String beginWord,String endWord,List<String> wordList,List<String> resultList,boolean[] visited){

    if(isFind) return;
    if(beginWord.equals(endWord)){
      res = new ArrayList<>(resultList);
      isFind=true;
      return;
    }

    for(int i=0;i<wordList.size();i++){

      if(visited[i]){
        continue;
      }
      if(canChange(beginWord,wordList.get(i))) {
        visited[i] = true;
        resultList.add(wordList.get(i));
        dfs(wordList.get(i), endWord, wordList, resultList, visited);
        visited[i] = false;
        resultList.remove(resultList.size() - 1);
      }
    }
  }

  private boolean canChange(String s1, String s2) {
    if(s1.length()!=s2.length()) return false;
    //记录可以转换的字母数
    int count = 0;
    for (int i = 0; i < s1.length(); i++) {
      if(s1.charAt(i)!=s2.charAt(i)) count++;
      if(count>1) return false;
    }
    return count==1;
  }

}
