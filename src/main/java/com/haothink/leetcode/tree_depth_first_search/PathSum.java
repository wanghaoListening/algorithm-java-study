package com.haothink.leetcode.tree_depth_first_search;

import java.util.Objects;

/**
 * Created by wanghao on 2021-04-18
 *
 * Given the root of a binary tree and an integer targetSum, return true if the tree
 * has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 **/
public class PathSum {

  public static void main(String[] args) {



  }



  public boolean hasPathSum(TreeNode root, int targetSum) {


    if(Objects.isNull(root)){

      return false;
    }

    if(Objects.isNull(root.left) && Objects.isNull(root.right) && root.val == targetSum){

      return true;
    }

    return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);

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
