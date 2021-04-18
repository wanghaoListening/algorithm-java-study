package com.haothink.leetcode.tree_depth_first_search;

import java.util.Objects;

/**
 * Created by wanghao on 2021-04-18
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 **/
public class MaximumDepthOfBinaryTree {


  public static void main(String[] args) {

  }


  public int maxDepth(TreeNode root) {

    if(Objects.isNull(root)) {
      return 0;
    }

    return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
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
