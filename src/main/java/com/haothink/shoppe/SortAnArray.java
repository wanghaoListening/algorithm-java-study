package com.haothink.shoppe;

import java.util.Arrays;

/**
 * Created by wanghao on 2021-06-29 mail:hiwanghao@didiglobal.com
 *
 * Given an array of integers nums, sort the array in ascending order.
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 *
 * quick sort
 *
 * Output Limit Exceeded
 **/
public class SortAnArray {


  public static void main(String[] args) {

    SortAnArray sortAnArray = new SortAnArray();
    int[] nums = {3,-1};
    System.out.println(Arrays.toString(sortAnArray.sortArray(nums)));
  }

  public int[] sortArray(int[] nums) {

    int headPointer = 0;
    int tailPointer = nums.length-1;

    quickSort(nums,headPointer,tailPointer);

    return nums;
  }

  public void quickSort(int[] nums,int headPointer,int tailPointer){

    if(tailPointer - headPointer <= 0){
      return;
    }
    //
    int benchEle = nums[headPointer];

    boolean tailMove = true;
    int currHeadPointer = headPointer;
    int currTailPointer = tailPointer;

    while (currHeadPointer < currTailPointer){

      if(tailMove){
        if(nums[currTailPointer] >= benchEle){
          currTailPointer--;

        }else {
          nums[currHeadPointer] = nums[currTailPointer];
          currHeadPointer++;
          tailMove = false;
        }
      }else {
        if(nums[currHeadPointer] <= benchEle){
          currHeadPointer++;
        }else {
          nums[currTailPointer] = nums[currHeadPointer];
          currTailPointer--;
          tailMove = true;
        }
      }

    }
    nums[currHeadPointer] = benchEle;
    System.out.println(Arrays.toString(nums));
    //左边
    quickSort(nums,headPointer,currHeadPointer-1);
    //右边
    quickSort(nums,currTailPointer+1,tailPointer);
  }


}
