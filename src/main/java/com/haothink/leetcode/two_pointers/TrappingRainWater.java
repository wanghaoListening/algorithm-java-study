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
 *
 * 需要 left 和 right 两个指针分别指向数组的首尾位置，从两边向中间扫描，在当前两指针确定的范围内，先比较两头找出较小值，
 * 如果较小值是 left 指向的值，则从左向右扫描，如果较小值是 right 指向的值，则从右向左扫描，若遇到的值比当较小值小，
 * 则将差值存入结果，如遇到的值大，则重新确定新的窗口范围，以此类推直至 left 和 right 指针重合
 **/
public class TrappingRainWater {


  public static void main(String[] args) {

    TrappingRainWater trappingRainWater = new TrappingRainWater();
    int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(trappingRainWater.trap(height));

  }



  public int trap(int[] height) {


    int left = 0;
    int flagLeft = left;
    int right = height.length-1;
    int flagRight = right;
    int amountOfWater = 0;

    while (left < right){

      if(height[left] >= height[right]){

        if(height[flagRight] > height[right-1]){

          amountOfWater+=height[flagRight]-height[right-1];
        }else {

          flagRight = right-1;
        }
        right --;
      }else {

        if(height[flagLeft] > height[left+1]) {
          amountOfWater += height[flagLeft] - height[left+1];
        }else {
          flagLeft = left+1;
        }
        left ++;
      }

    }

    return amountOfWater;
  }

}
