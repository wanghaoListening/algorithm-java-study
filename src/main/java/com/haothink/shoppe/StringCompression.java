package com.haothink.shoppe;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wanghao on 2021-07-11
 *
 * Given an array of characters chars, compress it using the following algorithm:
 *
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 *
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead be stored in the input
 * character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 *
 * After you are done modifying the input array, return the new length of the array.
 *
 * You must write an algorithm that uses only constant extra space.
 *
 * Input: chars = ["a","a","b","b","c","c","c"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 *
 **/
public class StringCompression {


  public static void main(String[] args) {

    char[] chars = {'a'};

    StringCompression stringCompression = new StringCompression();
    System.out.println(stringCompression.compress(chars));
    System.out.println(Arrays.toString(chars));
  }

  public int compress(char[] chars) {

    StringBuilder stringBuilder = new StringBuilder();

    char ch = chars[0];
    int groupCount = 1;
    for(int i=1;i<chars.length;i++){

     if(ch == chars[i]){
       groupCount++;
     }else {
       stringBuilder.append(ch);
       if(groupCount > 1){
         stringBuilder.append(groupCount);
       }
       ch = chars[i];
       groupCount = 1;
     }
    }
    stringBuilder.append(ch);
    if(groupCount > 1) {
      stringBuilder.append(groupCount);
    }
    char[] results = stringBuilder.toString().toCharArray();

    for(int i=0;i<results.length;i++){
      chars[i] = results[i];
    }
    return stringBuilder.length();
  }

}
