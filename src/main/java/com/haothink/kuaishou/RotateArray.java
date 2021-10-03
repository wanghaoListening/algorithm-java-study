package com.haothink.kuaishou;

import java.util.Arrays;

/**
 * Created by wanghao on 2021/10/3
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 * 解法一：辅助数组
 *
 * 我们利用原数组copy一份新数组，然后将copy[i]的元素赋值到nums[i+k]即可。注意下标i+k可能越界，
 * 因此我们需要求它与数组长度的余数。
 *
 * Runtime: 2 ms, faster than 36.08% of Java online submissions for Rotate Array.
 * Memory Usage: 56 MB, less than 83.95% of Java online submissions for Rotate Array.
 **/
public class RotateArray {


  public static void main(String[] args) {

    RotateArray rotateArray = new RotateArray();

    int[] nums = {-1,-100,3,99};
    int k = 2;

    System.out.println(Arrays.toString(nums));
    rotateArray.rotate(nums,k);
    System.out.println(Arrays.toString(nums));

  }

  public void rotate(int[] nums, int k) {

    if(null == nums || nums.length == 0 || k<1){

      return;
    }

    int[] newNums = Arrays.copyOf(nums,nums.length);

    for(int i=0;i<newNums.length;i++){
      int index = (i+k)%nums.length;
      nums[index] = newNums[i];
    }
  }
}
