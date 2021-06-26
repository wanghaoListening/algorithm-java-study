package com.haothink.leetcode.tree_depth_first_search;

/**
 * Created by wanghao on 2021-06-26
 **/
public class MaximumWidthOfBinaryTree {

  public static void main(String[] args) {

  }


  public int widthOfBinaryTree(TreeNode root) {

    return 0;
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
