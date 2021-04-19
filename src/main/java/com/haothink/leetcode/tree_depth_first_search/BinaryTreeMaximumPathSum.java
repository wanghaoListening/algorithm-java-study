package com.haothink.leetcode.tree_depth_first_search;

/**
 * Created by wanghao on 2021-04-19
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in
 * the sequence has an edge connecting them. A node can only appear in the sequence at
 * most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any path.
 **/
public class BinaryTreeMaximumPathSum {


  public static void main(String[] args) {

  }



  public int maxPathSum(TreeNode root) {

    return 1;
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
