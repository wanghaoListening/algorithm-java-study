package com.haothink.shoppe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by wanghao on 2021-07-06
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in
 * the result must be unique and you may return the result in any order.
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 *
 **/
public class IntersectionOfTwoArrays {


  public static void main(String[] args) {

    IntersectionOfTwoArrays intersection = new IntersectionOfTwoArrays();

    int[] nums1 = {4,9,5};
    int[] nums2 = {9,4,9,8,4};

    System.out.println(intersection.intersection(nums1,nums2));
  }


  public int[] intersection(int[] nums1, int[] nums2) {

    List<Integer> result = new ArrayList<>();
    Set<Integer> setNum1 = new HashSet<>();
    Set<Integer> setNum2 = new HashSet<>();

    for(int i=0;i<nums1.length;i++){

      setNum1.add(nums1[i]);
    }

    for(int i=0;i<nums2.length;i++){

      setNum2.add(nums2[i]);
    }

    Set<Integer> baseLineSet = setNum1.size() < setNum2.size()?setNum1:setNum2;

    Set<Integer> findEleSet = setNum2.size() > setNum1.size()?setNum2:setNum1;

    Iterator<Integer> it = baseLineSet.iterator();
    while (it.hasNext()) {
      Integer num = it.next();
      if(findEleSet.contains(num)){
        result.add(num);
        findEleSet.remove(num);
      }
    }

    int[] array = new int[result.size()];
    for(int i = 0; i < result.size(); i++) array[i] = result.get(i);

    return array;
  }

}
