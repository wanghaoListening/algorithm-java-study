package com.haothink.shoppe;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wanghao on 2021-07-02
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 **/
public class LongestSubstringWithoutRepeatingCharacters {


  public static void main(String[] args) {

  }


  public int lengthOfLongestSubstring(String s) {

    Set<Character> set = new HashSet<>();
    int n = s.length(), left = 0, right = 0;
    int result = 0;
    while (left < n && right < n) {
      if (!set.contains(s.charAt(right))) {
        set.add(s.charAt(right));
        right++;
        result = Math.max(result, right-left);
      } else {
        set.remove(s.charAt(left));
        left++;
      }
    }
    return result;
  }

}
