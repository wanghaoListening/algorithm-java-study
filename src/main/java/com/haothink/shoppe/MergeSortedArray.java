package com.haothink.shoppe;

import java.util.Arrays;

/**
 * Created by wanghao on 2021-06-29
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first
 * m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * 这个题的核心是注意到两个数组是已经有序的！这样就可以很简单的解决。
 * 方法是在每个数组的最后一个指定位置判断大小，根据判定的大小放到nums1的最后位置里，然后移动指针，继续判断，直到一个数组先遍历结束。
 **/
public class MergeSortedArray {

  public static void main(String[] args) {

    MergeSortedArray mergeSortedArray = new MergeSortedArray();

    int[] nums1 = {1,2,3,0,0,0};
    int[] nums2 = {4,5,6};

    mergeSortedArray.merge(nums1,3,nums2,3);

    System.out.println(Arrays.toString(nums1));
  }


  public void merge(int[] nums1, int m, int[] nums2, int n) {

    if(n == 0){

      return;
    }


    //从后向前进行插入排序
    int numOnePointer = m-1;
    int numTwoPointer = n-1;

    int emptyPointer = m+n-1;
    while (emptyPointer >= 0){

      if(numTwoPointer == -1){
        break;
      }
      if(numOnePointer < 0 && numTwoPointer >=0){

        while (numTwoPointer >=0){
          nums1[numTwoPointer] = nums2[numTwoPointer];
          numTwoPointer --;
        }
      }

      if(nums1[numOnePointer] >= nums2[numTwoPointer]){

        nums1[emptyPointer] = nums1[numOnePointer];
        numOnePointer --;
      }else {
        nums1[emptyPointer] = nums2[numTwoPointer];
        numTwoPointer --;
      }
      emptyPointer --;
    }

  }

}
