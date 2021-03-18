package com.haothink.leetcode.sliding_window;

/**
 * Created by wanghao on 2021-03-17
 *
 * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
 *
 * In one operation, you can choose any character of the string and change it to any other uppercase English character.
 *
 * Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
 *
 * Input:
 * s = "ABAB", k = 2
 *
 * Output:
 * 4
 *
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 *
 **/
public class LongestRepeatingCharacterReplacement {


  public static void main(String[] args) {

    LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
    String s = "ABAB";
    int k = 2;

    System.out.println(longestRepeatingCharacterReplacement.characterReplacement(s,k));
  }


  public int characterReplacement(String s, int k) {


    int longestRepeatingCharacter = 0;

    char[] chs = s.toCharArray();

    char currentCh = chs[0];
    int startIndex = 1;
    int endIndex = startIndex;
    int modifyCount = 0;
    while (endIndex < chs.length){

      if(modifyCount >= k){
        //the count of modify up to k limit
        if(endIndex-startIndex > longestRepeatingCharacter){

          longestRepeatingCharacter = endIndex-startIndex;
        }
        startIndex ++;
        endIndex = startIndex;
        currentCh = chs[startIndex];

      }

      if(modifyCount < k){

        if(currentCh != chs[endIndex]){
          modifyCount ++;
        }
        endIndex ++;

      }
    }

    return longestRepeatingCharacter;
  }

}
