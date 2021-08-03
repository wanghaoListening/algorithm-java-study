package com.haothink.shoppe;

/**
 * Created by wanghao on 2021/8/2 mail:hellotime@gmail.com
 * A peak element is an element that is strictly greater than its neighbors.
 *
 * Given an integer array nums, find a peak element, and return its index. If the array contains
 * multiple peaks, return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 *
 **/
public class FindPeakElement {

  public static void main(String[] args) {

  }

  public int findPeakElement(int[] nums) {

    if(nums.length <3){
      return 0;
    }
    int left = 1, right = nums.length - 2;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < nums[mid + 1]) left = mid + 1;
      else right = mid;
    }
    return right;
  }

}
