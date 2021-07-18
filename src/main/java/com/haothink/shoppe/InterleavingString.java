package com.haothink.shoppe;

import java.util.Objects;

/**
 * Created by wanghao on 2021-07-14
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 *
 * "aabcc"
 * "dbbca"
 * "aadbbcbcac"
 *
 * "aabcc"
 * "dbbca"
 * "aadbcbbcac"
 *
 * ""
 * "abc"
 * "ab"
 *
 *
 *
 * 解题思路有误,参考：https://zhuanlan.zhihu.com/p/69359753
 *
 **/
public class InterleavingString {


  public static void main(String[] args) {

    String s1 = "aa bc c";
    String s2 = "d bbca";
    String s3 = "aa d bc bbca c";

    InterleavingString interleavingString = new InterleavingString();
    System.out.println(interleavingString.isInterleave(s1,s2,s3));
  }


  public boolean isInterleave(String s1, String s2, String s3) {


    return isInterleave(s1,s2,s3,true) || isInterleave(s1,s2,s3,false);
  }


  public boolean isInterleave(String s1, String s2, String s3, boolean isleft) {

    if((Objects.isNull(s1) || s1.length() == 0)
        && (Objects.isNull(s2) || s2.length() == 0)
        && (Objects.isNull(s3) || s3.length() == 0)){

      return true;
    }

    if((Objects.isNull(s3) || s3.length() == 0)){

      return false;
    }

    if(isleft){
      char[] ch1 = s1.toCharArray();
      char[] ch3 = s3.toCharArray();

      int index = 0;
      int mixSize = Math.min(ch1.length,ch3.length);
      for(int i=0;i<mixSize;i++){

        if(ch1[i] == ch3[i]){
          index ++;
        }else {
          break;
        }
      }
      if(index == 0){
        return false;
      }
      return isInterleave(s1.substring(index),s2,s3.substring(index),false);
    }else {
      char[] ch2 = s2.toCharArray();
      char[] ch3 = s3.toCharArray();

      int index = 0;
      int mixSize = Math.min(ch2.length,ch3.length);
      for(int i=0;i<mixSize;i++){

        if(ch2[i] == ch3[i]){
          index ++;
        }else {
          break;
        }
      }
      if(index == 0){
        return false;
      }
      return isInterleave(s1,s2.substring(index),s3.substring(index),true);
    }
  }

}
