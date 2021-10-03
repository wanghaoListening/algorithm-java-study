package com.haothink.kuaishou;

import java.util.Random;

/**
 * Created by wanghao on 2021/10/3
 *
 * Given an integer array nums, design an algorithm to randomly shuffle the array.
 * All permutations of the array should be equally likely as a result of the shuffling.
 *
 * Implement the Solution class:
 *
 * Solution(int[] nums) Initializes the object with the integer array nums.
 * int[] reset() Resets the array to its original configuration and returns it.
 * int[] shuffle() Returns a random shuffling of the array.
 * 所谓打乱，意思就是原先每个位置上的数字会随机变换到其他位置
 *
 * 洗牌算法，所以果断用高爷爷改造过的Fisher-Yates shuffle
 **/
public class ShuffleAnArray {


  private int[] originArray = null;

  private int[] shuffleArray = null;

  Random r = new Random(); // 随机

  public ShuffleAnArray(int[] nums) {
    originArray = nums;
    shuffleArray = originArray.clone();
  }

  public int[] reset() {

    shuffleArray = originArray.clone();
    return shuffleArray;
  }

  public int[] shuffle() {

    // 循环数组每一位
    for(int i=shuffleArray.length-1;i>=0;i--){
      // 当前位的值
      int current=shuffleArray[i];
      // 随机生成一个小于数组长度的下标
      int ir = r.nextInt(shuffleArray.length);
      // 交换当前位置与随机下标位置上的数字
      shuffleArray[i]=shuffleArray[ir];
      shuffleArray[ir]=current;
    }
    return shuffleArray;
  }
}
