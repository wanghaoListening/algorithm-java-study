package com.haothink.leetcode.two_pointers;

/**
 * Created by wanghao on 2021-03-29
 *
 * Your are given an array of positive integers nums.
 *
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the
 * subarray is less than k.
 *
 * Input: nums = [10, 5, 2, 6], k = 100 Output: 8 Explanation: The 8 subarrays that have product
 * less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]. Note that [10, 5, 2]
 * is not included as the product of 100 is not strictly less than k.
 *
 * 维护一个数字乘积刚好小于k的滑动窗口，用变量 left 来记录其左边界的位置，右边界i就是当前遍历到的位置。遍历原数组，用 prod 乘上当前遍历到的数字， 然后进行 while 循环，如果
 * prod 大于等于k，则滑动窗口的左边界需要向右移动一位，删除最左边的数字，那么少了一个数字，乘积就会改变，所以用 prod 除以最左边的数字，然后左边右移一位，即 left
 * 自增1。当确定了窗口的大小后，就可以统计子数组的个数了，就是窗口的大小。
 **/
public class SubarrayProductLessThanK {


  public static void main(String[] args) {

    SubarrayProductLessThanK subarrayProductLessThanK = new SubarrayProductLessThanK();

    int[] nums = {10, 5, 2, 6};
    int k = 100;

    System.out.println(subarrayProductLessThanK.numSubarrayProductLessThanK(nums, k));
  }

  public int numSubarrayProductLessThanK(int[] nums, int k) {

    int left = 0;
    int right = 0;
    int sum = nums[0];
    int count = 0;

    while (left <= right){

      if(sum < k){
        count ++;
        if(right == nums.length-1 && left == nums.length-1){
          return count;
        }
        if(right >= nums.length-1) {
          left ++;
          sum = nums[left];
          right = left;
        }else {
          right ++;
          sum *= nums[right];
        }
      }else {
        if(right == nums.length-1 && left == nums.length-1){
          return count;
        }
        left ++;
        sum = nums[left];
        right = left;
      }
    }
    return count;
  }

  public int numSubarrayProductLessThanKBF(int[] nums, int k) {

    int count = 0;
    int end = 0;
    int product = 1;
    for (int i = 0; i < nums.length; i++) {

      product = 1;
      end = i;
      while (end < nums.length) {
        product = product * nums[end];
        if (product < k) {
          count++;
        } else {
          break;
        }
        end++;
      }
    }

    return count;
  }

}
