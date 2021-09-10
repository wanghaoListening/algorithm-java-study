package com.haothink.bytedance;

/**
 * Created by wanghao on 2021/9/9
 *
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
 *
 * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * Output: 3
 * Explanation: The repeated subarray with maximum length is [3,2,1].
 *
 * Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * Output: 5
 *
 * 动态规划
 **/
public class MaximumLengthOfRepeatedSubarray {

  public static void main(String[] args) {

    int[] nums1 = {1,2,3,2,1,0,5}; int[] nums2 = {3,2,1,4,7,5};

    MaximumLengthOfRepeatedSubarray maximumLengthOfRepeatedSubarray = new MaximumLengthOfRepeatedSubarray();

    System.out.println(maximumLengthOfRepeatedSubarray.findLength(nums1,nums2));
  }


  public int findLength(int[] nums1, int[] nums2) {

    int maxLength = 0;
    int m = nums1.length;
    int n = nums2.length;
    int[][] dp = new int[m+1][n+1];
    for(int i=1;i<=m;i++){
      for(int j=1;j<=n;j++){
        if(nums1[i-1] == nums2[j-1]){
          dp[i][j] = dp[i-1][j-1]+1;
          maxLength = Math.max(maxLength, dp[i][j]);
        }
      }
    }
    return maxLength;
  }


}
