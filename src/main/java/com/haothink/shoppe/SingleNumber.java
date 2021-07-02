package com.haothink.shoppe;

/**
 * Created by wanghao on 2021-07-02
 *
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * 题目中让我们不使用额外空间来做，本来是一道非常简单的题，但是由于加上了时间复杂度必须是 O(n)，并且空间复杂度为 O(1)，
 * 使得不能用排序方法，也不能使用 HashSet 数据结构
 * 由于数字在计算机是以二进制存储的，每位上都是0或1，如果我们把两个相同的数字异或，0与0 '异或' 是0，1与1 '异或' 也是0，那么我们会得到0。
 * 根据这个特点，我们把数组中所有的数字都 '异或' 起来，则每对相同的数字都会得0，然后最后剩下来的数字就是那个只有1次的数字。
 **/
public class SingleNumber {

  public static void main(String[] args) {

  }

  public int singleNumber(int[] nums) {

    int res = 0;
    for(int num : nums){
      res ^= num;
    }
    return res;
  }

}
