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
 *
 * a + b + c = 0 意味着三个数字必须有复数或者正数，或者三个数字全为0
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
    List<List<Integer>> resultList = new ArrayList<>();

    //sort nums
    Arrays.sort(nums);

    int startIndex = 0;
    int endIndex = nums.length-1;


    for(int i=0;i<nums.length;i++){

      if(nums[i] > 0){
        //skip out of the loop
        break;
      }
      startIndex = i+1;
      while (startIndex < endIndex) {
        int sum = nums[i] + nums[startIndex] + nums[endIndex];
        if (sum == 0){
          List<Integer> result = new ArrayList<>();
          result.add(nums[i]);
          result.add(nums[startIndex]);
          result.add(nums[endIndex]);
          resultList.add(result);
          startIndex ++;
          endIndex --;
        }
        if(sum < 0){
          startIndex++;
        }

        if(sum > 0){
          endIndex--;
        }
      }

    }

    return resultList;
  }




}
