package com.haothink.leetcode.tree_depth_first_search;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by wanghao on 2021-06-26
 *
 * You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively
 * from nums using the following algorithm:
 *
 * Create a root node whose value is the maximum value in nums.
 * Recursively build the left subtree on the subarray prefix to the left of the maximum value.
 * Recursively build the right subtree on the subarray suffix to the right of the maximum value.
 * Return the maximum binary tree built from nums.
 **/
public class MaximumBinaryTree {


  public static void main(String[] args) {

    int[] nums = {3,2,1,6,0,5};

    System.out.println(Arrays.toString(Arrays.copyOfRange(nums,0,3)));
    System.out.println(Arrays.toString(Arrays.copyOfRange(nums,3,nums.length)));
  }


  public TreeNode constructMaximumBinaryTree(int[] nums) {

    if(Objects.isNull(nums) || nums.length == 0){

      return null;
    }
    int indexOfLargestValue = getIndexOfLargest(nums);
    int largestValue = nums[indexOfLargestValue];

    TreeNode root = new TreeNode();
    root.val = largestValue;

    int[] leftNums = Arrays.copyOfRange(nums,0,indexOfLargestValue);
    int[] rightNums = Arrays.copyOfRange(nums,indexOfLargestValue+1,nums.length);

    TreeNode leftNode = constructMaximumBinaryTree(leftNums);
    TreeNode rightNode = constructMaximumBinaryTree(rightNums);
    root.left = leftNode;
    root.right = rightNode;
    return root;
  }

  public int getIndexOfLargest(int[] array ) {
    if ( array == null || array.length == 0 ) return -1; // null or empty

    int indexOfLargestValue = 0;
    for ( int i = 1; i < array.length; i++ ) {
      if (array[i] > array[indexOfLargestValue]) indexOfLargestValue = i;
    }
    return indexOfLargestValue; // position of the first largest found
  }



  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
