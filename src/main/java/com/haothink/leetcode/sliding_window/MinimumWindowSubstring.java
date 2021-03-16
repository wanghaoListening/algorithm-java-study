package com.haothink.leetcode.sliding_window;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021-03-14 mail:
 *
 * "bdab"
 * "ab"
 *
 * "ADOBECODEBANC"
 * "ABC"
 **/
public class MinimumWindowSubstring {


  public static void main(String[] args) {

    MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
    System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC","ABC"));
  }



  public String minWindow(String s, String t) {

    if(s.equals(t)){

      return t;
    }
    char[] chs = s.toCharArray();
    List<Integer> charFlag = new ArrayList<>();

    String tempStr = t;
    int startIndex = 0;

    int endIndex = 0;

    int minimumLengthOfWindow = -1;

    String minimumWindowStr = "";

    for(int i=0;i<chs.length;i++){
      if(tempStr.indexOf(chs[i]) != -1) {
        charFlag.add(i);
      }
    }

    for(int i=0;i<chs.length;i++){

      if(tempStr.indexOf(chs[i]) != -1){

        tempStr = tempStr.substring(0, tempStr.indexOf(chs[i])) + tempStr.substring(tempStr.indexOf(chs[i]) + 1);

        if((t.length() - tempStr.length()) == 1){
          startIndex = i;
        }
      }

      if(("".equals(tempStr) || tempStr.length() == 0)){

        if((minimumLengthOfWindow == -1)||(endIndex - startIndex) < minimumLengthOfWindow) {
          minimumLengthOfWindow = endIndex - startIndex;
          minimumWindowStr = s.substring(startIndex, endIndex+1);
          tempStr = t;
          //remove the first element
          charFlag.remove(0);
          //next turn ,the i will add 1 ,so minus 1 firstly
          i = charFlag.get(0)-1;
          startIndex = i;
          endIndex = i;
        }
      }

      endIndex ++;

    }
    return minimumWindowStr;
  }




}
