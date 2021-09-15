package com.haothink.bytedance;

/**
 * Created by wanghao on 2021/9/15
 *
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has
 * the largest product, and return the product.
 *
 * It is guaranteed that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * 而本题是求最大区间乘积。两题最本质的区别是在对负数的处理上，求和时，加上一个负数，总和一定变小，
 * 而乘上一个负数，结果可能变大也可能变小（负数乘以负数结果会变大）。因此我们需要新建2个变量，
 * 一个代表区间内最大乘积max，另一个代表区间内最小乘积min，首元素区间的最大乘积与最小乘积均为该数字本身。
 * 我们从数组第二个数字开始循环，当前数字与前区间能形成的最大乘积，一定在下面三个元素中产生：
 **/
public class MaximumProductSubarray {

  public static void main(String[] args) {

    int[] nums = {0,2};
    MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
    System.out.println(maximumProductSubarray.maxProduct(nums));
  }

  public int maxProduct(int[] nums){
    if(null == nums || nums.length == 0){
      return 0;
    }
    int maxProduct = nums[0];
    int max = nums[0]; //当前区间最大乘积
    int min = nums[0]; //当前区间最小乘积
    for(int i=1;i<nums.length;i++){
      if(nums[i] < 0){
        int temp = max;
        max = min;
        min = temp;
      }
      max = Math.max(max * nums[i], nums[i]);
      min = Math.min(min * nums[i], nums[i]);
      maxProduct = Math.max(maxProduct,max);
    }
    return maxProduct;
  }


}
