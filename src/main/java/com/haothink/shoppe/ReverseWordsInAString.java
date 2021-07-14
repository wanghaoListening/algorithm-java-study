package com.haothink.shoppe;

/**
 * Created by wanghao on 2021-07-14
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should
 * only have a single space separating the words. Do not include any extra spaces.
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 **/
public class ReverseWordsInAString {


  public static void main(String[] args) {


    String s = "  hello world  ";

    ReverseWordsInAString wordsInAString = new ReverseWordsInAString();
    System.out.println(wordsInAString.reverseWords(s));
  }


  public String reverseWords(String s) {


    String[] chs = s.split("\\s+");

    String space = " ";

    StringBuilder stringBuilder = new StringBuilder();

    for(int i=chs.length-1;i>=0;i--){

      if(!" ".equals(chs[i])) {
        stringBuilder.append(chs[i]);
        stringBuilder.append(space);
      }
    }

    return stringBuilder.toString().trim();
  }

}
