package com.haothink.bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wanghao on 2021/9/11
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 **/
public class LongestConsecutiveSequence {

  public int longestConsecutive(int[] nums) {

    Set<Integer> numSet = new HashSet<Integer>();
    for (int num : nums)
      numSet.add(num);

    int longestStrak = 0;
    for (int num : numSet) {
      if (!numSet.contains(num - 1)) {
        int curNum = num;
        int curStrak = 1;
        while (numSet.contains(++curNum)) ++curStrak;
        longestStrak = Math.max(longestStrak, curStrak);
      }
    }
    return longestStrak;

  }
}
