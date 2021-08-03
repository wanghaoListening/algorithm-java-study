package com.haothink.shoppe;

import java.util.Arrays;

/**
 * Created by wanghao on 2021/7/30 mail:hellotime@gmail.com
 *
 * Given an array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 *
 * Return the indices of the two numbers (1-indexed) as an integer array answer of size 2,
 * where 1 <= answer[0] < answer[1] <= numbers.length.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 **/
public class TwoSumIIInputArrayIsSorted {

  public static void main(String[] args) {

    int[] numbers = {2,7,11,15};

    TwoSumIIInputArrayIsSorted sumIIInputArrayIsSorted = new TwoSumIIInputArrayIsSorted();

    System.out.println(Arrays.toString(sumIIInputArrayIsSorted.twoSum(numbers,9)));
  }

  public int[] twoSum(int[] numbers, int target) {

    int[] result = new int[2];

    int startIndex = 0;
    int endIndex = numbers.length-1;

    while (startIndex < endIndex){

      if(numbers[startIndex] + numbers[endIndex] == target){

        result[0] = startIndex+1;
        result[1] = endIndex+1;
        return result;
      }else if(numbers[startIndex] + numbers[endIndex] > target){
        endIndex --;
      }else {
        startIndex++;
      }
    }

    return result;
  }
}
