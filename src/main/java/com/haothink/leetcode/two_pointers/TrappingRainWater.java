package com.haothink.leetcode.two_pointers;

/**
 * Created by wanghao on 2021-03-24
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 **/
public class TrappingRainWater {


  public static void main(String[] args) {

    TrappingRainWater trappingRainWater = new TrappingRainWater();
    int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(trappingRainWater.trap(height));

  }



  public int trap(int[] height) {


    return 0;
  }

}
