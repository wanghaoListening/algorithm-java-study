package com.haothink.shoppe;

import java.util.Locale;

/**
 * Created by wanghao on 2021/7/22
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 **/
public class ValidPalindrome {


  public static void main(String[] args) {

    String str = "0P";

    ValidPalindrome validPalindrome = new ValidPalindrome();
    System.out.println(validPalindrome.isPalindrome(str));
  }

  public boolean isPalindrome(String s) {
  s = s.toLowerCase();
  char[] chs = s.toCharArray();
  int startIndex = 0;
  int endIndex = chs.length-1;
  while (startIndex <= endIndex){
    if(!Character.isLetterOrDigit(chs[startIndex])){
      startIndex ++;
      continue;
    }
    if(!Character.isLetterOrDigit(chs[endIndex])){
      endIndex --;
      continue;
    }
    if(chs[startIndex] != chs[endIndex]){
      return false;
    }
    startIndex++;
    endIndex--;
  }
    return true;
  }

}
