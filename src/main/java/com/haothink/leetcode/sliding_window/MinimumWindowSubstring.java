package com.haothink.leetcode.sliding_window;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wanghao on 2021-03-14 mail:
 *
 * "bdab"
 * "ab"
 *
 * "ADOBECODEBANC"
 * "ABC"
 *
 * 最终超时限制，后期待优化Time Limit Exceeded
 *
 **/
public class MinimumWindowSubstring {


  public static void main(String[] args) {

    MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
    System.out.println(minimumWindowSubstring.minWindow("ab","b"));
  }



  public String minWindow(String s, String t) {

    if(s.equals(t)){

      return t;
    }
    char[] chs = s.toCharArray();
    Queue<Integer> charFlag = new LinkedList<>();

    String tempStr = t;
    int endIndex = 0;

    int minimumLengthOfWindow = -1;

    String minimumWindowStr = "";

    for(int i=0;i<chs.length;i++){
      if(tempStr.indexOf(chs[i]) != -1) {
        charFlag.add(i);
      }
    }
    if(charFlag.size() <=0){

      return "";
    }

    int startIndex = charFlag.remove();
    for(int i=0;i<chs.length;i++){

      int currentIndex = tempStr.indexOf(chs[i]);
      if(currentIndex != -1){

        tempStr = tempStr.substring(0, currentIndex) + tempStr.substring(currentIndex + 1);

      }

      if(("".equals(tempStr) || tempStr.length() == 0)){

        if((minimumLengthOfWindow == -1)||(endIndex - startIndex) < minimumLengthOfWindow) {
          minimumLengthOfWindow = endIndex - startIndex;
          minimumWindowStr = s.substring(startIndex, endIndex+1);

        }
        tempStr = t;

        if(charFlag.size() > 0) {
          //remove the first element
          //next turn ,the i will add 1 ,so minus 1 firstly
          i = charFlag.remove();
          startIndex = i;
          endIndex = i - 1;
          i--;
        }
      }

      endIndex ++;

    }
    return minimumWindowStr;
  }




}
