package com.haothink.microsoft;

import java.util.Objects;

/**
 * Created by wanghao on 2021/8/24
 *
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 *
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 *
 * Given a string s containing only digits, return the number of ways to decode it.
 *
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 * Example 1:
 *
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 **/
public class DecodeWays {


  public static void main(String[] args) {

    DecodeWays decodeWays = new DecodeWays();
    System.out.println(decodeWays.numDecodings("0"));
  }

  public int ways = 0;

  public int numDecodings(String s) {

    if(Objects.isNull(s) || s.length() <=0){

      return 0;
    }
    splitAndCountString(s);
    return ways;
  }

  private void splitAndCountString(String s){

    if(Objects.isNull(s) || s.length() <=0 || (s.length()==1 && isValidNumber(s))){
      ways++;
      return;
    }
    if(s.length()==1 && !isValidNumber(s)){
      return;
    }

    if(isValidNumber(s.substring(0,1))) {
      splitAndCountString(s.substring(1));
    }
    if(isValidNumber(s.substring(0,2))){
      splitAndCountString(s.substring(2));
    }
  }



  private boolean isValidNumber(String numberStr){

    if(Objects.isNull(numberStr) || numberStr.length() <=0){

      return false;
    }

    if(numberStr.startsWith("0")){

      return false;
    }

    int number = Integer.parseInt(numberStr);

    if(number >=1 && number <=26){

      return true;
    }else {
      return false;
    }
  }
}
