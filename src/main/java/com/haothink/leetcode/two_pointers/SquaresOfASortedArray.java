package com.haothink.leetcode.two_pointers;

import java.util.Arrays;

/**
 * Created by wanghao on 2021-03-31
 *
 * Given an integer array nums sorted in non-decreasing order, return an array of
 * the squares of each number sorted in non-decreasing order.
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 **/
public class SquaresOfASortedArray {


  public static void main(String[] args) {

    SquaresOfASortedArray squaresOfASortedArray = new SquaresOfASortedArray();
    int[] nums = {-7,-3,2,3,11};
    System.out.println(Arrays.toString(squaresOfASortedArray.sortedSquares(nums)));
  }

  public int[] sortedSquares(int[] nums) {

    int[] result = new int[nums.length];

    int start=0;
    int end=nums.length-1;
    int pointer = nums.length-1;
    while (start <= end){

      if(Math.abs(nums[end]) >= Math.abs(nums[start])){

        result[pointer] = (int)Math.pow(nums[end],2);
        end --;

      }else {

        result[pointer] = (int)Math.pow(nums[start],2);
        start ++;
      }
      pointer--;

    }

    return result;
  }
}
