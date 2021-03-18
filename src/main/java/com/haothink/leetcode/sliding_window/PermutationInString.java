package com.haothink.leetcode.sliding_window;

/**
 * Created by wanghao on 2021-03-18 mail
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of
 * the first string's permutations is the substring of the second string.
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba")
 *
 * "adc"
 * "dcda".
 *
 * Time Limit Exceeded
 **/
public class PermutationInString {


  public static void main(String[] args) {

    PermutationInString permutationInString = new PermutationInString();
    String s1 = "adc";
    String s2 = "dcda";

    System.out.println(permutationInString.checkInclusion(s1,s2));
  }


  public boolean checkInclusion(String s1, String s2) {
    int startIndex = 0;
    int endIndex = startIndex;
    int index = -1;
    char[] chs = s2.toCharArray();
    StringBuilder tempStr = new StringBuilder(s1);

    while (endIndex < chs.length){


      if((index = tempStr.indexOf(chs[endIndex]+"")) != -1){

        tempStr.deleteCharAt(index);
        endIndex ++;

      }else {
        startIndex++;
        endIndex = startIndex;
        tempStr = new StringBuilder(s1);
      }

      if(tempStr.length() == 0){

        return true;
      }

    }

    return false;
  }



}
