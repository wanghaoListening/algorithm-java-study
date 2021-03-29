package com.haothink.leetcode.two_pointers;

import java.util.Arrays;

/**
 * Created by wanghao on 2021-03-29 mail
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same
 * color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 *
 **/
public class SortColors {


  public static void main(String[] args) {

    SortColors sortColors = new SortColors();
    int[] nums = {2,0,2,1,1,0};
    sortColors.sortColors(nums);
    System.out.println(Arrays.toString(nums));
  }


  public void sortColors(int[] nums) {

    int left = 0;
    int right = nums.length-1;
    int slidePoint = 0;
    int temp = -1;
    //left pointer point position of 0,right pointer point position of 2
    boolean isSwap = false;
    while (slidePoint <= right){

      isSwap = false;
      if(nums[slidePoint] == 0){
        //swap left ele and slidePoint ele
        temp = nums[slidePoint];
        nums[slidePoint] = nums[left];
        nums[left] = temp;
        left ++;
        isSwap = true;
      }else if(nums[slidePoint] == 2){
        //swap left ele and slidePoint ele
        temp = nums[slidePoint];
        nums[slidePoint] = nums[right];
        nums[right] = temp;
        right --;
        isSwap = true;
      }
      if(!isSwap || slidePoint < left) {
        slidePoint++;
      }
    }

  }


}
