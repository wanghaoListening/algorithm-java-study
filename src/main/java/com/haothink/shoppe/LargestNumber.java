package com.haothink.shoppe;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

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

    Set<Integer> set = new TreeSet<>(new HighBitComparator());
    for(Integer num : nums){
      set.add(num);
    }
    StringBuilder largestNumberStr = new StringBuilder();
    for(Integer ele : set){
      largestNumberStr.append(ele);
    }
    return largestNumberStr.toString();
  }



  public class HighBitComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
      String num1 = String.valueOf(o1);
      String num2 = String.valueOf(o2);

      int minLength = Math.min(num1.length(),num2.length());

      for(int i=0;i<minLength;i++){

        if(num1.charAt(i) > num2.charAt(i)){

          return -1;
        }else if(num1.charAt(i) < num2.charAt(i)){

          return 1;
        }
      }
      return num1.length() - num2.length();
    }
  }
}
