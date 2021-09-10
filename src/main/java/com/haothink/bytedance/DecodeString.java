package com.haothink.bytedance;

import java.util.LinkedList;

/**
 * Created by wanghao on 2021/9/10
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square
 * brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for
 * those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 *
 * "100[leetcode]"
 **/
public class DecodeString {


  public static void main(String[] args) {

    String s = "100[leetcode]";
    DecodeString decodeString = new DecodeString();
    System.out.println(decodeString.decodeString(s));
  }

  public String decodeString(String s) {

    if(null == s || s.length() == 0){
      return s;
    }
    StringBuilder stringBuilder = new StringBuilder();
    char[] chs = s.toCharArray();
    for(int i=0;i<chs.length;i++){

      if(chs[i] == ']'){
        //get nearest ch until [
        copyStr(stringBuilder);
      }else {
        stringBuilder.append(chs[i]);
      }
    }
    return stringBuilder.toString();
  }


  public void copyStr(StringBuilder stringBuilder){

    int index = stringBuilder.lastIndexOf("[");
    String needCopyStr = stringBuilder.substring(index+1);
    stringBuilder.delete(index,stringBuilder.length());
    StringBuilder digit = new StringBuilder();

    for(int i=stringBuilder.length()-1;i>=0;i--){
      if(!Character.isDigit(stringBuilder.charAt(i))){
        break;
      }else {
        digit.insert(0,stringBuilder.charAt(i));
        stringBuilder.deleteCharAt(i);
      }
    }

    StringBuilder result = new StringBuilder();
    for(int i=0;i<Integer.parseInt(digit.toString());i++){
      result.append(needCopyStr);
    }
    stringBuilder.append(result);
  }

}
