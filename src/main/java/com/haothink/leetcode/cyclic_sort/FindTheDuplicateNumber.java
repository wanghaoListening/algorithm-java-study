package com.haothink.leetcode.cyclic_sort;

/**
 * Created by wanghao on 2021-04-09
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 **/
public class FindTheDuplicateNumber {


  public static void main(String[] args) {

    FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();

    int[] nums = {1,3,4,2,2};
    System.out.println(findTheDuplicateNumber.findDuplicate(nums));
  }

  public int findDuplicate(int[] nums) {

    int temp = -1;
    for(int i=0;i<nums.length;i++){

      if(nums[i] == 0){
        continue;
      }

      if(nums[i] != (i+1)){
        //swap nums[i] to nums[i] value index position
        if(nums[i] == nums[nums[i]-1]){
          //duplicate num
          return nums[i];
        }
        temp = nums[nums[i]-1];
        nums[nums[i]-1] = nums[i];
        nums[i] = temp;
        i--;
      }
    }

    return 0;

  }

}
