package com.haothink.shoppe;

/**
 * Created by wanghao on 2021-07-04
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 * 选择排序
 * 或者快速排序
 **/
public class KthLargestElementInAnArray {


  public static void main(String[] args) {


    int[] nums = {7,6,5,4,3,2,1};
    int k = 2;
    KthLargestElementInAnArray largestElementInAnArray = new KthLargestElementInAnArray();

    System.out.println(largestElementInAnArray.findKthLargest(nums,k));

  }

  public int findKthLargest(int[] nums, int k) {

    for(int i=0;i<k;i++){

      int initValueIndex = 0;
      for(int j=1;j<nums.length-i;j++){

        if(nums[initValueIndex] > nums[j]){
          int temp = nums[j];
          nums[j] = nums[initValueIndex];
          nums[initValueIndex] = temp;

        }
        initValueIndex = j;
      }
    }
    return nums[nums.length-k];
  }

}
