package com.haothink.shoppe;

import java.util.Arrays;

/**
 * Created by wanghao on 2021-06-27
 *
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 **/
public class BinarySearch {

  public static void main(String[] args) {

    int[] nums = {2,5};

    BinarySearch binarySearch = new BinarySearch();
    System.out.println(binarySearch.search(nums,5));
  }


  public int search(int[] nums, int target) {

    if(nums.length <= 1){

      if(nums[0] == target){
        return 0;
      }else {
        return -1;
      }
    }

    int start = 0;
    int end = nums.length-1;
    int middle = (start + end)/2;
    while (start <= end){

      if(target == nums[middle]){

        return middle;
      }else if(target > nums[middle]){
        start = middle +1;

      }else {
        end = middle -1;
      }
      middle = (start + end)/2;
    }
    return -1;
  }


}
