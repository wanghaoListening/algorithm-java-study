package com.haothink.shoppe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanghao on 2021-07-10
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must
 * appear as many times as it shows in both arrays and you may return the result in any order.
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 **/
public class IntersectionOfTwoArraysII {


  public static void main(String[] args) {

    int[] nums1 = {4,9,5};

    int[] nums2 = {9,4,9,8,4};

    IntersectionOfTwoArraysII intersection =  new IntersectionOfTwoArraysII();

    System.out.println(Arrays.toString(intersection.intersect(nums1,nums2)));
  }




  public int[] intersect(int[] nums1, int[] nums2) {

    int[] maxNum = nums1.length > nums2.length ? nums1:nums2;

    int[] minNum = nums1.length > nums2.length ? nums2:nums1;

    Map<Integer,Integer> baselineMap = new HashMap<>();

    for(int i=0;i<maxNum.length;i++){

      int key = maxNum[i];
      if(baselineMap.containsKey(key)){

        baselineMap.put(key,baselineMap.get(key)+1);
      }else {

        baselineMap.put(key,1);
      }
    }

    List<Integer> numList = new ArrayList<>();

    for(int i=0;i<minNum.length;i++){

      if(!baselineMap.containsKey(minNum[i])){

        continue;
      }

      int numCount = baselineMap.get(minNum[i]);
      if(numCount > 1){
        baselineMap.put(minNum[i],--numCount);
      }else {
        baselineMap.remove((minNum[i]));
      }
      numList.add(minNum[i]);
    }

    int[] result = new int[numList.size()];

    for(int i=0;i<numList.size();i++){

      result[i] = numList.get(i);
    }

    return result;
  }

}
