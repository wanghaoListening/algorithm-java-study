package com.haothink.leetcode.tree_breadth_first_search;

import java.util.List;

/**
 * Created by wanghao on 2021-04-18
 *
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 *
 * Return a list of the values of all nodes that have a distance K from the target node.
 * The answer can be returned in any order.
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 *
 * Output: [7,4,1]
 *
 * Explanation:
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 *
 *
 * Solutions:
 *
 **/
public class AllNodesDistanceKInBinaryTree {


  public static void main(String[] args) {

  }


  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {


    return null;
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
