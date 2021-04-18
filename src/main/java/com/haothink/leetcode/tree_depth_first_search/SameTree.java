package com.haothink.leetcode.tree_depth_first_search;

import java.util.Objects;

/**
 * Created by wanghao on 2021-04-18
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have
 * the same value.
 **/
public class SameTree {


  public static void main(String[] args) {

  }

  public boolean isSameTree(TreeNode p, TreeNode q) {


    if(Objects.isNull(p) && Objects.isNull(q)){

      return true;
    }

    if(Objects.nonNull(p) && Objects.nonNull(q)){

      boolean result = (p.val == q.val);
      boolean leftResult = isSameTree(p.left,q.left);
      boolean rightResult = isSameTree(p.right,q.right);

      return result && leftResult && rightResult;

    }else {
      return false;
    }
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
