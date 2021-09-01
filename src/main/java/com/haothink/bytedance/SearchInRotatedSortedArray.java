package com.haothink.bytedance;

/**
 * Created by wanghao on 2021/8/31
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the rotation and an integer target, return the index of target if it is in nums,
 * or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Input: nums = [1], target = 0
 * Output: -1
 * 如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的,
 * 我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了
 *
 **/
public class SearchInRotatedSortedArray {


  public static void main(String[] args) {

    int[] nums = {1,3,5}; int target = 1;

    SearchInRotatedSortedArray inRotatedSortedArray = new SearchInRotatedSortedArray();

    System.out.println(inRotatedSortedArray.search(nums,target));
  }

  public int search(int[] nums, int target) {

    // sanity check
    if(null == nums || nums.length == 0){
      return -1;
    }
    int startIndex = 0;
    int endIndex = nums.length-1;
    while (startIndex <= endIndex){
      int midIndex = (startIndex + endIndex)/2;
      if(nums[midIndex] == target){
        return midIndex;
      }
      if(nums[midIndex] < nums[endIndex]){
        //右边有序
        if (nums[midIndex] < target && nums[endIndex] >= target) startIndex = midIndex + 1;
        else endIndex = midIndex - 1;
      }else {
        //左边有序
        if (nums[startIndex] <= target && target<nums[midIndex]) endIndex = midIndex - 1;
        else startIndex = midIndex + 1;
      }

    }
    return -1;
  }
}
