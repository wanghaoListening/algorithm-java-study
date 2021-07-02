package com.haothink.shoppe;

import java.util.Objects;

/**
 * Created by wanghao on 2021-07-02
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 * 解题思路，求左右字数的高度差
 * 注意：左右子树也要符合平衡条件
 **/
public class BalancedBinaryTree {


  public static void main(String[] args) {

  }

  public boolean isBalanced(TreeNode root) {

    if(Objects.isNull(root)){

      return true;
    }
    int heightOfLeft = height(root.left);
    int heightOfRight = height(root.right);

    if(Math.abs(heightOfLeft-heightOfRight) >1) return false;

    return isBalanced(root.left) && isBalanced(root.right);
  }

  public int height(TreeNode root){

    if(Objects.isNull(root)){

      return 0;
    }
    int heightOfLeft = height(root.left);
    int heightOfRight = height(root.right);

    return (heightOfLeft>heightOfRight) ? heightOfLeft+1:heightOfRight+1;
  }

  public static class TreeNode {
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
