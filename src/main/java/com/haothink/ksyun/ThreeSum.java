package com.haothink.ksyun;

import java.util.List;

/**
 * Created by wanghao on 2021/9/16
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
 * i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Input: nums = []
 * Output: []
 *
 * Input: nums = [0]
 * Output: []
 *
 * 1.先将数组排序
 *
 * 2.循环遍历数组元素，采用双指针法，如：当前元素下标为 i ，则低指针为  i+1， 高指针为 arr.length - 1 .
 *
 * 3.如果三下标所对应元素的和大于0，则 高指针减小一，如果和小于0则低指针加一， 否则 则等于 0。
 *
 * 4.如果等于0，再判断有没有重复元素。
 *
 **/
public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {

    return null;
  }
}
