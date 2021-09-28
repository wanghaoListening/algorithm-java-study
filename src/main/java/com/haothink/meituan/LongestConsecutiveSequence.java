package com.haothink.meituan;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wanghao on 2021/9/28
 *
 *
 **/
public class LongestConsecutiveSequence {

  //出现内存 Memory Limit Exceeded
  public int longestConsecutive(int[] nums) {

    if(null== nums || nums.length <=0){
      return 0;
    }
    int min = nums[0];
    int max = nums[0];
    for (int i = 0; i < nums.length; i++) {
      min = Math.min(min, nums[i]);
      max = Math.max(max, nums[i]);
    }
    int[] dp = new int[max - min + 1];
    for (int i = 0; i < nums.length; i++) {
      dp[nums[i] - min] = 1;
    }
    max = 0;
    int count = 0;
    for(int i = 0; i < dp.length; i++){

      if(dp[i] == 1){
        count ++;
      }else {
        count = 0;
      }
      max = Math.max(count,max);
    }
    return max;
  }

  //set 优化
  public int longestConsecutiveSet(int[] nums) {

    if(null== nums || nums.length <=0){
      return 0;
    }

    Set<Integer> set = new HashSet<>();
    for(int num : nums){
      set.add(num);
    }
    int max = 0;
    int count =0;
    for(int i=0;i<nums.length;i++){

      if(!set.contains(nums[i]-1)){

        int num = nums[i];
        while (set.contains(num)){
          count++;
          num++;
        }
        max = Math.max(count,max);
        count = 0;
      }
    }
    return max;
  }
}
