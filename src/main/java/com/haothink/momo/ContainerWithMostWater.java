package com.haothink.momo;

/**
 * Created by wanghao on 2021/9/27
 **/
public class ContainerWithMostWater {

  public int maxArea(int[] height) {

    int before = 0;
    int after = height.length-1;
    int maxArea=0;
    while(before < after){

      int minHeight = Math.min(height[before],height[after]);
      maxArea = Math.max(minHeight*(after-before),maxArea);

      if(height[before] <=height[after]){
        before ++;
      }else{
        after --;
      }
    }
    return maxArea;
  }

}
