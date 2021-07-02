package com.haothink.shoppe;

import java.util.Objects;
import java.util.Observable;

/**
 * Created by wanghao on 2021-07-01
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 **/
public class LongestCommonPrefix {


  public static void main(String[] args) {

    String[] strs = {"flower","flow","flight"};

    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
  }


  public String longestCommonPrefix(String[] strs) {

    if(Objects.isNull(strs) || strs.length == 0){

      return "";
    }

    StringBuilder stringBuilder = new StringBuilder();
    char prefixChar;

    for(int i=0;i<strs[0].length();i++){

      prefixChar = strs[0].charAt(i);
      for(String str : strs){

        if(str.length()-1 < i || str.charAt(i) != prefixChar){
          return stringBuilder.toString();
        }
      }
      stringBuilder.append(prefixChar);
    }

    return stringBuilder.toString();
  }

}
