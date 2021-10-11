package com.haothink.kuaishou;

/**
 * Created by wanghao on 2021/10/11
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
 * the max area of water (blue section) the container can contain is 49.
 **/
public class ContainerWithMostWater {


  public static void main(String[] args) {

    int[] height = {1,8,6,2,5,4,8,3,7};

    ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
    System.out.println(containerWithMostWater.maxArea(height));
  }

  public int maxArea(int[] height) {

    int startIndex = 0;
    int endIndex = height.length-1;

    int maxArea = 0;

    while (startIndex < endIndex){

      maxArea = Math.max(Math.min(height[startIndex],height[endIndex])*(endIndex-startIndex),maxArea);

      if(height[startIndex]<=height[endIndex]){
        startIndex++;
      }else {
        endIndex--;
      }
    }
    return maxArea;
  }
}
