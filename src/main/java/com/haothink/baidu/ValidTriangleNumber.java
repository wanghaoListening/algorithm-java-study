package com.haothink.baidu;


import java.util.Arrays;


/**
 * Created by wanghao on 2021/9/17
 *
 * Given an integer array nums, return the number of triplets chosen from the array that
 * can make triangles if we take them as side lengths of a triangle.
 *
 * Input: nums = [2,2,3,4]
 * Output: 3
 * Explanation: Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 *
 * Input: nums = [4,2,3,4]
 * Output: 4
 *
 * 在一个三角形中，任意两边之和大于第三边，任意两边之差小于第三边。
 * 三个数字中如果较小的两个数字之和大于第三个数字，那么任意两个数字之和都大于第三个数字，这很好证明，
 * 因为第三个数字是最大的，所以它加上任意一个数肯定大于另一个数。
 **/
public class ValidTriangleNumber {

  public static void main(String[] args) {

    int[] nums = {2,2,3,4};

    ValidTriangleNumber validTriangleNumber = new ValidTriangleNumber();

    System.out.println(validTriangleNumber.triangleNumber(nums));
  }

  public int triangleNumber(int[] nums) {

    int result = 0;
    if(null == nums || nums.length <=2){
      return 0;
    }
    Arrays.sort(nums);
    for(int i=nums.length-1;i>=2;i--){
      //从后往前遍历，每次固定一条最长边
      int left=0;
      int right=i-1;
      while(left<right){
        if(nums[left]+nums[right]>nums[i]){
          result+=right-left;
          right--;
        }else{
          left++;
        }
      }
    }
    return result;
  }


}
