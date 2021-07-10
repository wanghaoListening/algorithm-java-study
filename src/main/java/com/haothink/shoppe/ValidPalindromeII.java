package com.haothink.shoppe;

/**
 * Created by wanghao on 2021-07-10
 *
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 * Input: s = "aba"
 * Output: true
 *
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 *
 * 删除最多一个字符
 *
 * 此方法速度有待提升
 **/
public class ValidPalindromeII {


  public static void main(String[] args) {

    String str = "abc";
    ValidPalindromeII validPalindromeII = new ValidPalindromeII();
    System.out.println(validPalindromeII.validPalindrome(str));

  }

  public boolean validPalindrome(String s) {

    return isValid(s,1);
  }

  public boolean isValid(String s,int deleteCount){

    char[] chs = s.toCharArray();
    int startIndex = 0;
    int endIndex = chs.length-1;

    while (startIndex <= endIndex){

      if(chs[startIndex] != chs[endIndex]){

        if(deleteCount >= 1){
          return isValid(removeCharAt(s,startIndex),--deleteCount) || isValid(removeCharAt(s,endIndex),--deleteCount);
        }
        return false;

      }
      startIndex ++;
      endIndex--;
    }

    return true;
  }

  public static String removeCharAt(String s, int pos) {
    return s.substring(0, pos) + s.substring(pos + 1);
  }
}
