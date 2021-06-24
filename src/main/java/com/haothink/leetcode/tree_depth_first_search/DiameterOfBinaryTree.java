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
 * 需要注意最长的path可能不经过根节点
 * 由二叉树的特性得，二叉树的直径为左右子数edges之和
 **/
public class DiameterOfBinaryTree {


  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    TreeNode left = new TreeNode(2);

    root.left = left;

    DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();

    int diameter = diameterOfBinaryTree.diameterOfBinaryTree(root);
    System.out.println(diameter);
  }

  /**
   * leetcode 当中用static会出错，需要用实例变量
   */
  private static int diameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {

    dfsHeightOfBinaryTree(root);
    return diameter;
  }

  public int dfsHeightOfBinaryTree(TreeNode root){

    if(Objects.isNull(root)){

      return 0;
    }

    int heightOfLeft =  dfsHeightOfBinaryTree(root.left);
    int heightOfRight = dfsHeightOfBinaryTree(root.right);

    diameter = Math.max(heightOfLeft+heightOfRight,diameter);

    return Math.max(heightOfLeft,heightOfRight)+1;
  }

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
