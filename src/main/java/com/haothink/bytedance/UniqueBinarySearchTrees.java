package com.haothink.bytedance;

/**
 * Created by wanghao on 2021/10/14
 *
 * Given an integer n, return the number of structurally unique BST's (binary search trees)
 * which has exactly n nodes of unique values from 1 to n.
 *
 * Input: n = 3
 * Output: 5
 *
 * Input: n = 1
 * Output: 1
 **/
public class UniqueBinarySearchTrees {

  public int numTrees(int n) {

    int[] nums = new int[n+1];
    nums[0] = 1;
    nums[1] = 1;

    for(int i=2;i<=n;i++){

      int temp = 0;
      for(int j=0;j<i;j++){
        temp+=nums[j] * nums[i-j-1];
      }
      nums[i] =temp;
    }

    return nums[n];
  }

}
