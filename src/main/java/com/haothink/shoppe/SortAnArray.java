package com.haothink.shoppe;

/**
 * Created by wanghao on 2021-06-29 mail:hiwanghao@didiglobal.com
 *
 * Given an array of integers nums, sort the array in ascending order.
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 *
 * quick sort
 **/
public class SortAnArray {


  public int[] sortArray(int[] nums) {

    int benchEle = nums[0];

    int headPointer = 0;
    int tailPointer = nums.length-1;



    return null;
  }

  public void quickSort(int[] nums){

    int benchEle = nums[0];

    int headPointer = 0;
    int tailPointer = nums.length-1;

    while (headPointer < tailPointer){

      if(nums[tailPointer] > benchEle){

        tailPointer--;
        continue;
      }
      if(nums[headPointer] < benchEle){

        headPointer++;
        continue;
      }

    }
  }
}
