package com.haothink.tencent;

import java.util.Arrays;

/**
 * Created by wanghao on 2021/8/22
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements
 * without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence
 * of the array [0,3,1,6,2,2,7].
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 * 利用DP思想来进行解析
 *
 *
 **/
public class LongestIncreasingSubsequence {


  public static void main(String[] args) {

    int[] nums = {10,9,2,5,3,7,101,18};
    LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
    System.out.println(longestIncreasingSubsequence.lengthOfLIS(nums));

  }

  public int lengthOfLIS(int[] nums) {

    if(0 == nums.length) {
      return 0;
    }
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    int max = 1;
    for(int i = 0; i < nums.length; ++i) {
      for(int j = 0; j < i; ++j) {
        if(nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
