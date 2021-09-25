package com.haothink.kuaishou;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanghao on 2021/9/25
 *
 * Given an integer array nums where every element appears three times except for one,
 * which appears exactly once. Find the single element and return it.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Input: nums = [2,2,3,2]
 * Output: 3
 *
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 *
 * Bit Manipulation
 **/
public class SingleNumberII {


  public static void main(String[] args) {

    SingleNumberII singleNumberII = new SingleNumberII();

    int[] nums = {0,1,0,1,0,1,99};
    System.out.println(singleNumberII.singleNumber(nums));
  }

  public int singleNumber(int[] nums) {

    Map<Integer,Integer> map = new HashMap<>();

    for(Integer num : nums){
      if(map.containsKey(num)){
        if(map.get(num) == 2){
          map.remove(num);
        }else {
          map.put(num,map.get(num)+1);
        }
      }else {
        map.put(num,1);
      }
    }
    return map.keySet().stream().findFirst().get();
  }

  public int singleNumberBit(int[] nums) {
    int a = 0, b = 0;
    for (int i = 0; i < nums.length; ++i) {
      b = (b ^ nums[i]) & ~a;
      a = (a ^ nums[i]) & ~b;
    }
    return b;
  }


}
