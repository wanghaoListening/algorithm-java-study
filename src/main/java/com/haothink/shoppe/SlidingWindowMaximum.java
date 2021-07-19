package com.haothink.shoppe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by wanghao on 2021-07-18
 *
 *You are given an array of integers nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 *
 *Return the max sliding window.
 *
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * Time Limit Exceeded
 **/
public class SlidingWindowMaximum {


  public static void main(String[] args) {

    SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

    int[] nums = {1,-1};
    System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(nums,1)));
  }


  public int[] maxSlidingWindow(int[] nums, int k) {

    List<Integer> numList = new ArrayList<>();
    int maxValue ;
    for(int i=0;i<nums.length-k+1;i++){
      maxValue = nums[i];
      for(int j=i;j<i+k-1;j++){

        if(nums[j] > maxValue){
          maxValue = nums[j];
        }
      }
      numList.add(maxValue);
    }
    int[] result = new int[numList.size()];
    for(int i=0;i<numList.size();i++){

      result[i] = numList.get(i);
    }
    return result;
  }


}
