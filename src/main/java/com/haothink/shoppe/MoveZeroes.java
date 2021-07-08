package com.haothink.shoppe;

import java.util.Arrays;

/**
 * Created by wanghao on 2021-07-08
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 **/
public class MoveZeroes {


  public static void main(String[] args) {

    int[] nums = {0,1,0,3,12};

    MoveZeroes moveZeroes = new MoveZeroes();
    moveZeroes.moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }


  //采用选择排序的方式
  public void moveZeroes(int[] nums) {

    //第一轮统计0的个数
    int numberOfZero = 0;
    for(int i=0;i<nums.length;i++){

      if(0 == nums[i]){
        numberOfZero ++;
      }
    }

    int index = 1;

    while (index <= numberOfZero){
      int beforeIndex = 0;
      int afterIndex = 1;
      while (afterIndex <= nums.length-index) {
        if (nums[beforeIndex] == 0) {
          nums[beforeIndex] = nums[afterIndex];
          nums[afterIndex] = 0;

        }
        beforeIndex++;
        afterIndex++;
      }
      index++;

    }


  }


}
