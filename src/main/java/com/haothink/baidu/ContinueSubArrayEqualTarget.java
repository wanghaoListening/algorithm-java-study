package com.haothink.baidu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021/10/8
 *
 * 1.给一个有序的整数数组 1，2，2，3，4，5，6，7，8，9
 * 给一个整数7，然后求数组中连续元素相加等于7的子数组
 **/
public class ContinueSubArrayEqualTarget {

  public static void main(String[] args) {

    int[] nums = {1,2,2,3,4,5,6,7,8,9};
    int target = 7;

    List<List<Integer>> resultList = getSubArray(nums,target);
    System.out.println(resultList);

  }



  public static List<List<Integer>> getSubArray(int[] nums,int target){

    List<List<Integer>> resultList = new ArrayList<>();

    int startIndex = 0;
    int endIndex = 0;
    while (startIndex < nums.length-1){

      endIndex = startIndex;
      int sum = 0;
      List<Integer> result = new ArrayList<>();
      while (endIndex < nums.length-1){

        if(sum < target){
          result.add(nums[endIndex]);
          sum += nums[endIndex];
          endIndex++;
          continue;
        }
        if(sum > target){
          break;
        }
        resultList.add(result);
        break;
      }
      startIndex ++;
    }
    return resultList;
  }
}
