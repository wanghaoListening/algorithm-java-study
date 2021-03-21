package com.haothink.leetcode.two_pointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanghao on 2021-03-21 mail:
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 **/
public class TwoSum {


  public static void main(String[] args) {

    int[] nums = {3,2,4};
    int target = 6;

    TwoSum twoSum = new TwoSum();

    System.out.println(Arrays.toString(twoSum.twoSum(nums,target)));
  }

  public int[] twoSum(int[] nums, int target) {

    Map<Integer, Integer> indicesMap = new HashMap<>();

    for(int i=0;i<nums.length;i++){

      int remainValue = target - nums[i];
      if(indicesMap.containsKey(remainValue)){

        return new int[]{indicesMap.get(remainValue),i};
      }
      indicesMap.put(nums[i],i);
    }
    return new int[0];
  }
}
