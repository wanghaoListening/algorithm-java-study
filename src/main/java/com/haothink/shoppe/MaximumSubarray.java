package com.haothink.shoppe;

/**
 * Created by wanghao on 2021-06-30
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * 需要优化
 **/
public class MaximumSubarray {


  public static void main(String[] args) {

    MaximumSubarray maximumSubarray = new MaximumSubarray();

    int[] nums = {-2,-1};

    System.out.println(maximumSubarray.maxSubArray(nums));
  }


  public int maxSubArray(int[] nums) {

    int i=0;
    int globalMaxValue = nums[i];
    while (i <= nums.length-1){

      int j= i;
      int localMaxValue = 0;
      while (j <= nums.length-1){

        localMaxValue +=nums[j];
        globalMaxValue = (localMaxValue > globalMaxValue)?localMaxValue:globalMaxValue;
        j++;
      }
      i++;
    }
    return globalMaxValue;
  }


}
