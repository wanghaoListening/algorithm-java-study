package com.haothink.kuaishou;

/**
 * Created by wanghao on 2021/10/3
 *
 * You may recall that an array arr is a mountain array if and only if:
 *
 * arr.length >= 3
 * There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given an integer array arr, return the length of the longest subarray, which is a mountain.
 * Return 0 if there is no mountain subarray.
 *
 * Input: arr = [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 *
 * Input: arr = [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 *
 * [0,1,2,3,4,5,4,3,2,1,0] Runtime Error
 *
 * [0,1,2,3,4,5,6,7,8,9]
 **/
public class LongestMountainInArray {


  public static void main(String[] args) {

    int[] arr = {0,1,2,3,4,5,4,3,2,1,0};
    LongestMountainInArray longestMountainInArray = new LongestMountainInArray();
    System.out.println(longestMountainInArray.longestMountain(arr));
  }

  public int longestMountain(int[] arr) {

    if(null== arr || arr.length <3){
      return 0;
    }
    int leftIndex = 0;
    int rightIndex = 0;
    int maxLength = 0;
    for(int i=1;i<arr.length-1;i++){
      leftIndex = i;
      rightIndex = i;
      while (leftIndex > 0 && arr[leftIndex-1] < arr[leftIndex]){
        leftIndex--;
      }
      while (rightIndex<arr.length-1 && arr[rightIndex] > arr[rightIndex+1]){
        rightIndex++;
      }
      if(rightIndex-leftIndex == 0 || leftIndex == i || rightIndex ==i){
        continue;
      }
      maxLength = Math.max(rightIndex-leftIndex+1,maxLength);
    }
    return maxLength;
  }
}
