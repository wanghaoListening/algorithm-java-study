package com.haothink.leetcode.tree_depth_first_search;

/**
 * Created by wanghao on 2021-06-26
 *
 * Given the root of a binary tree, return the maximum width of the given tree.
 *
 * The maximum width of a tree is the maximum width among all levels.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes),
 * where the null nodes between the end-nodes are also counted into the length calculation.
 *
 * It is guaranteed that the answer will in the range of 32-bit signed integer.
 *
 * Input: root = [1,3,2,5,3,null,9]
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 *
 * Input: root = [1,3,null,5,3]
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 *
 * 给定二叉树，求二叉树的最大宽度。二叉树某层的宽度是指其最左非空节点与最右非空节点之间的跨度。
 *
 * 可以使用dfs
 *
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
