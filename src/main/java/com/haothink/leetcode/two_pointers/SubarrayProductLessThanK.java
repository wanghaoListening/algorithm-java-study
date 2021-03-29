package com.haothink.leetcode.two_pointers;

/**
 * Created by wanghao on 2021-03-29
 *
 * Your are given an array of positive integers nums.
 *
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 *
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 **/
public class SubarrayProductLessThanK {


  public static void main(String[] args) {


    SubarrayProductLessThanK subarrayProductLessThanK = new SubarrayProductLessThanK();

    int[] nums = {10, 5, 2, 6};
    int k = 100;

    System.out.println(subarrayProductLessThanK.numSubarrayProductLessThanK(nums,k));
  }

  public int numSubarrayProductLessThanK(int[] nums, int k) {



    return 0;
  }

}
