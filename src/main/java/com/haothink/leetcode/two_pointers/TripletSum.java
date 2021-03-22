package com.haothink.leetcode.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wanghao on 2021-03-22
 *
 *Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *Input: nums = [-1,0,1,2,-1,-4]
 *Output: [[-1,-1,2],[-1,0,1]]
 **/
public class TripletSum {


  public static void main(String[] args) {

    TripletSum tripletSum = new TripletSum();

    int[] nums = {-1,0,1,2,-1,-4};

    System.out.println(tripletSum.threeSum(nums));
  }

  public List<List<Integer>> threeSum(int[] nums) {

    if(nums.length <= 2){
      //corner case
      return new ArrayList<>();
    }

    //sort nums
    Arrays.sort(nums);

    int startIndex = 0;
    int endIndex = nums.length-1;

    while (startIndex < endIndex){

      //fixed startIndex and endIndex position nums ,find another num to make nums[startIndex]+nums[endIndex]+nums[another] ==0

      int diff = nums[startIndex] + nums[endIndex];

      if(diff >= 0){
        //from startIndex to endIndex

      }else {
        //from endIndex to startIndex

      }


    }

    return null;
  }




}
