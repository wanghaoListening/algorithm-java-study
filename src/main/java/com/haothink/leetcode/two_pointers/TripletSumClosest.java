package com.haothink.leetcode.two_pointers;


import java.util.Arrays;

/**
 * Created by wanghao on 2021-03-23
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is
 * closest to target. Return the sum of the three integers. You may assume that each input would have exactly
 * one solution.
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 **/
public class TripletSumClosest {


  public static void main(String[] args) {

    TripletSumClosest tripletSumClosest =new TripletSumClosest();

    int[] nums = {-1,2,1,-4};
    int target = 1;
    System.out.println(tripletSumClosest.threeSumClosest(nums,target));

  }


  public int threeSumClosest(int[] nums, int target) {


    int closestNum = 0;

    //sort nums
    Arrays.sort(nums);

    int startIndex;
    int endIndex;

    for(int i=0;i<nums.length;i++){

      if(nums[i] > 0){
        //skip out of the loop
        break;
      }
      startIndex = i+1;
      endIndex = nums.length-1;
      while (startIndex < endIndex) {

        int sum = nums[i] + nums[startIndex] + nums[endIndex];
        if (sum == 0){

          return 0;
        }
        if(sum < 0){
          startIndex++;
        }

        if(sum > 0){
          endIndex--;
        }
      }

    }

    return closestNum;
  }
}
