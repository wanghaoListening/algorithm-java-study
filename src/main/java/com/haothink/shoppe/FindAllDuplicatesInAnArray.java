package com.haothink.shoppe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021-07-13
 *
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each
 * integer appears once or twice, return an array of all the integers that appears twice.
 *
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 *
 * 因为题意说数组的元素值的范围是： 1 ≤ a[i] ≤ n (n = size of array),。 所以，我们将数组值对应到新数组的元素下标，出现一次，值就+1，
 * 最后判断新数组的元素值，如果大于二，就将这个元素的下标加入到 ret 中
 *
 **/
public class FindAllDuplicatesInAnArray {


  public static void main(String[] args) {


    FindAllDuplicatesInAnArray findAllDuplicatesInAnArray = new FindAllDuplicatesInAnArray();

    int[] nums = {4,3,2,7,8,2,3,1};
    System.out.println(findAllDuplicatesInAnArray.findDuplicates(nums));
  }

  public List<Integer> findDuplicates(int[] nums) {


    int[] flagArray = new int[nums.length+1];

    for(int i=0;i<nums.length;i++){

      flagArray[nums[i]]++;
    }

    List<Integer> res = new ArrayList<>();

    for(int i=1;i<flagArray.length;i++){

      if(flagArray[i] == 2){
        res.add(i);
      }
    }

    return res;

  }

}
