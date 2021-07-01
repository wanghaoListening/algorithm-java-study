package com.haothink.shoppe;

/**
 * Created by wanghao on 2021-07-01
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 **/
public class FindFirstAndLastPositionOfElementInSortedArray {

  public static void main(String[] args) {

    int[] nums = {5,7,7,8,8,10};
    FindFirstAndLastPositionOfElementInSortedArray fsortedArray = new FindFirstAndLastPositionOfElementInSortedArray();
    System.out.println(fsortedArray.searchRange(nums,8));
  }

  public int[] searchRange(int[] nums, int target) {

    if(nums.length ==0){
      return new int[]{-1,-1};
    }
    int index = search(nums,target);
    if(index == -1){

      return new int[]{-1,-1};
    }
    int varyLeftIndex = index;
    int varyRightIndex = index;
    while (varyLeftIndex >=0 && nums[varyLeftIndex] == target){

      varyLeftIndex--;
    }
    while (varyRightIndex <=nums.length-1 && nums[varyRightIndex] == target){

      varyRightIndex++;
    }
    varyLeftIndex ++;
    varyRightIndex --;


    return new int[]{varyLeftIndex,varyRightIndex};
  }


  public int search(int[] nums, int target) {

    if(nums.length <= 1){

      if(nums[0] == target){
        return 0;
      }else {
        return -1;
      }
    }

    int start = 0;
    int end = nums.length-1;
    int middle = (start + end)/2;
    while (start <= end){

      if(target == nums[middle]){

        return middle;
      }else if(target > nums[middle]){
        start = middle +1;

      }else {
        end = middle -1;
      }
      middle = (start + end)/2;
    }
    return -1;
  }

}
