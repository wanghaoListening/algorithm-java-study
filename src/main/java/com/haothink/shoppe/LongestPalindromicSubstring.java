package com.haothink.shoppe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanghao on 2021-07-04
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * 时间faster than 5.42% of Java online submissions for Longest Palindromic Substring.
 *
 **/
public class LongestPalindromicSubstring {


  public static void main(String[] args) {

    String s = "babad";

    LongestPalindromicSubstring palindromicSubstring = new LongestPalindromicSubstring();

    System.out.println(palindromicSubstring.longestPalindrome(s));
  }

  public String longestPalindrome(String s) {

    if(s.length() == 1){

      return s;
    }
    List<PalindromeRange> palindromeRangeList = new ArrayList<>();

    char[] chs = s.toCharArray();

    for(int i=0;i<chs.length;i++){

      int endIndex = i+1;
      while (endIndex < chs.length){

        if(chs[endIndex] == chs[i]){
          palindromeRangeList.add(new PalindromeRange(i,endIndex));
        }
        endIndex ++;
      }
    }

    int maxLength = 0;
    PalindromeRange maxPalindromeRange = null;
    for(PalindromeRange palindromeRange : palindromeRangeList){

      if(isPalindrome(chs,palindromeRange.startIndex,palindromeRange.endIndex)
          && (palindromeRange.endIndex-palindromeRange.startIndex) > maxLength){
        maxLength = palindromeRange.endIndex-palindromeRange.startIndex;
        maxPalindromeRange = palindromeRange;
      }
    }
    if(Objects.isNull(maxPalindromeRange)){

      return chs[0]+"";
    }
    StringBuilder stringBuilder = new StringBuilder();
    for(int i= maxPalindromeRange.startIndex;i<=maxPalindromeRange.endIndex;i++){
      stringBuilder.append(chs[i]);
    }
    return stringBuilder.toString();
  }

  public boolean isPalindrome(char[] chs,int startIndex,int endIndex){


    while (startIndex <= endIndex){

      if(chs[startIndex] != chs[endIndex]){

        return false;
      }
      startIndex ++;
      endIndex --;
    }
    return true;
  }

  public static class PalindromeRange{

    public PalindromeRange(int startIndex, int endIndex) {
      this.startIndex = startIndex;
      this.endIndex = endIndex;
    }

    public int startIndex;
    public int endIndex;
  }
}
