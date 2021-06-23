package com.haothink.leetcode.tree_depth_first_search;

import java.util.Objects;

/**
 * Created by wanghao on 2021-06-23
 *
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * 求二叉树的直径
 * 由二叉树的特性得，二叉树的直径为左右子数edges之和
 **/
public class DiameterOfBinaryTree {


  public static void main(String[] args) {

  }

  public int diameterOfBinaryTree(TreeNode root) {

    if(Objects.isNull(root)){

      return 0;
    }

    if(Objects.isNull(root.left) && Objects.isNull(root.right)){

      return 0;
    }

    return dfsHeightOfBinaryTree(root);
  }

  public int dfsHeightOfBinaryTree(TreeNode root){

    if(Objects.isNull(root)){

      return 0;
    }

    if(Objects.isNull(root.left) && Objects.isNull(root.right)){

      return 1;
    }
    int heightOfLeft =  dfsHeightOfBinaryTree(root.left);
    int heightOfRight = dfsHeightOfBinaryTree(root.right);

    return heightOfLeft + heightOfRight;
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
