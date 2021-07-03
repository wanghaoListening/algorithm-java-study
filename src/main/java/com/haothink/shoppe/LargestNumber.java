package com.haothink.shoppe;

import java.util.Arrays;
import java.util.Comparator;


/**
 * Created by wanghao on 2021-07-03
 *
 * Given a list of non-negative integers nums, arrange them such that they form the largest number.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * Input: nums = [10,2]
 * Output: "210"
 *
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 **/
public class LargestNumber {

  public static void main(String[] args) {


    int[] nums = {3,30,34,5,9};

    LargestNumber largestNumber = new LargestNumber();
    System.out.println(largestNumber.largestNumber(nums));
  }


  //sort it and compose it
  public String largestNumber(int[] nums) {

    String[] arr = new String[nums.length];
    for(int i=0; i<nums.length; i++){
      arr[i]=String.valueOf(nums[i]);
    }

    Arrays.sort(arr, new Comparator<String>(){
      public int compare(String a, String b){
        return (b+a).compareTo(a+b);
      }
    });
    StringBuilder largestNumberStr = new StringBuilder();
    for(String ele : arr){
      largestNumberStr.append(ele);
    }
    while(largestNumberStr.charAt(0)=='0'&&largestNumberStr.length()>1)
      largestNumberStr.deleteCharAt(0);
    return largestNumberStr.toString();
  }



}
