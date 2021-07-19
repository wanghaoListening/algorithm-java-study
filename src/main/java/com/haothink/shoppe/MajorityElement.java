package com.haothink.shoppe;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanghao on 2021-07-19
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that
 * the majority element always exists in the array.
 *
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 **/
public class MajorityElement {


  public static void main(String[] args) {

  }


  public int majorityElement(int[] nums) {

    int majorityElementCount = nums.length/2;

    Map<Integer,Integer> majorityElementMap = new HashMap<>();
    for(int i=0;i<nums.length;i++){

      if(majorityElementMap.containsKey(nums[i])){

        majorityElementMap.put(nums[i],majorityElementMap.get(nums[i])+1);
      }else {
        majorityElementMap.put(nums[i],1);
      }
    }

    for(Map.Entry<Integer,Integer> entry : majorityElementMap.entrySet()){

      if(entry.getValue() > majorityElementCount){

        return entry.getKey();
      }
    }
    return 0;
  }

}
