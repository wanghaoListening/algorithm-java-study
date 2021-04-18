package com.haothink.leetcode.tree_depth_first_search;

import java.util.Arrays;

/**
 * Created by wanghao on 2021-04-18
 *
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of
 * a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 **/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {


  public static void main(String[] args) {


    int[] preorder = {3,9,20,15,7};
    int[] inorder = {9,3,15,20,7};


    ConstructBinaryTreeFromPreorderAndInorderTraversal traversal = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
    TreeNode root = traversal.buildTree(preorder,inorder);
    System.out.println(root);
  }


  public TreeNode buildTree(int[] preorder, int[] inorder) {

    if(preorder.length <= 0){

      return null;
    }

    if(preorder.length == 1){

      return new TreeNode(preorder[0]);
    }

    TreeNode root = new TreeNode(preorder[0]);

    int rootIndex = 0;
    for(int i=0;i<inorder.length;i++){

      if(inorder[i] == preorder[0]){

        rootIndex = i;
        break;
      }
    }

    //split inorder to two part
    int[] leftInOrder = Arrays.copyOfRange(inorder,0,rootIndex);

    int[] rightInOrder = Arrays.copyOfRange(inorder,rootIndex+1,inorder.length);

    //split preOrder to two part
    int[] leftPreOrder = Arrays.copyOfRange(preorder,1,leftInOrder.length+1);

    int[] rightPreOrder = Arrays.copyOfRange(preorder,leftInOrder.length+1,inorder.length);

    TreeNode leftNode = buildTree(leftPreOrder,leftInOrder);

    TreeNode rightNode = buildTree(rightPreOrder,rightInOrder);

    root.left = leftNode;
    root.right = rightNode;

    return root;
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
