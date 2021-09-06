package com.haothink.bytedance;

import java.util.Arrays;

/**
 * Created by wanghao on 2021/9/5
 *
 * Given two version numbers, version1 and version2, compare them.
 *
 * Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits
 * and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed
 * from left to right, with the leftmost revision being revision 0, the next revision being revision 1,
 * and so on. For example 2.5.33 and 0.1 are valid version numbers.
 *
 * To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using
 * their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal.
 * If a version number does not specify a revision at an index, then treat the revision as 0. For example,
 * version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0
 * and 1 respectively, and 0 < 1.
 *
 * Return the following:
 *
 * If version1 < version2, return -1.
 * If version1 > version2, return 1.
 * Otherwise, return 0.
 *
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
 *
 * Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Explanation: version1 does not specify revision 2, which means it is treated as "0".
 *
 *
 **/
public class CompareVersionNumbers {


  public static void main(String[] args) {
    CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();

    System.out.println(compareVersionNumbers.compareVersion("7.5.2.4","7.5.3"));
  }


  public int compareVersion(String version1, String version2) {

    String[] version1Char = version1.split("\\.");
    String[] version2Char = version2.split("\\.");

    if(version1Char.length>version2Char.length){
      version2Char = constructNewCharArray(version1Char.length,version2Char);
    }else if(version1Char.length<version2Char.length){
      version1Char = constructNewCharArray(version2Char.length,version1Char);
    }

    for(int i=0;i<version1Char.length;i++){

      int num1 = Integer.parseInt(version1Char[i]);
      int num2 = Integer.parseInt(version2Char[i]);

      if(num1 > num2){
        return 1;
      }else if(num2 > num1){
        return -1;
      }
    }
    return 0;
  }

  private String[] constructNewCharArray(int length, String[] version2Char) {

    String[] newCharArray = new String[length];
    Arrays.fill(newCharArray, "0");
    System.arraycopy(version2Char,0,newCharArray,0,version2Char.length);

    return newCharArray;
  }

}
