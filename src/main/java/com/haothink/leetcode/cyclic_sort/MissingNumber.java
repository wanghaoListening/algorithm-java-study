package com.haothink.leetcode.cyclic_sort;

/**
 * Created by wanghao on 2021-04-09
 *
 * Given an array nums containing n distinct numbers in the range [0, n], return the
 * only number in the range that is missing from the array.
 *
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 *
 * 如果问题让你需要在排好序/反转过的数组中，寻找丢失的/重复的/最小的元素
 **/
public class MissingNumber {


  public static void main(String[] args) {


    MissingNumber missingNumber = new MissingNumber();

    int[] nums = {9,6,4,2,3,5,7,0,1};
    System.out.println(missingNumber.missingNumber(nums));
  }


  public int missingNumber(int[] nums) {


    int temp = -1;
    for(int i=0;i<nums.length;i++){

      if(nums[i] == 0){
        continue;
      }

      if(nums[i] != (i+1)){
        //swap nums[i] to nums[i] value index position
        temp = nums[nums[i]-1];
        nums[nums[i]-1] = nums[i];
        nums[i] = temp;
        i--;
      }
    }

    for(int i=0;i<nums.length;i++){

      if(nums[i] == 0){
        return (i+1);
      }
    }
    return 0;

  }



}
