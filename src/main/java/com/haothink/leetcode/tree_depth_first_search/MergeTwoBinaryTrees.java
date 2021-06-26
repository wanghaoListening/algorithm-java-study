package com.haothink.leetcode.tree_depth_first_search;

import java.util.Objects;

/**
 * Created by wanghao on 2021-06-24
 *
 * You are given two binary trees root1 and root2.
 *
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the
 * others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node
 * of the new tree.
 *
 * Return the merged tree.
 *
 * Note: The merging process must start from the root nodes of both trees.
 **/
public class MergeTwoBinaryTrees {


  public static void main(String[] args) {

  }


  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

    if(Objects.isNull(root1) && Objects.isNull(root2)){

      return null;
    }

    TreeNode newNode = new TreeNode();
    TreeNode left = null;
    TreeNode right = null;
    if(Objects.nonNull(root1) && Objects.nonNull(root2)){


      newNode.val = root1.val + root2.val;
      left = mergeTrees(root1.left,root2.left);
      right = mergeTrees(root1.right,root2.right);


    }else {
      if (Objects.nonNull(root1)) {

        newNode.val = root1.val;
        left = mergeTrees(root1.left, null);
        right = mergeTrees(root1.right, null);

      }
      if (Objects.nonNull(root2)) {
        newNode.val = root2.val;
        left = mergeTrees(root2.left, null);
        right = mergeTrees(root2.right, null);
      }
    }
    newNode.left = left;
    newNode.right = right;

    return newNode;
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
