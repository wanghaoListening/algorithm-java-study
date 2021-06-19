package com.haothink.leetcode.tree_depth_first_search;

import java.util.Objects;

/**
 * Created by wanghao on 2021-06-19
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 *
 *
 **/
public class InvertBinaryTree {


  public static void main(String[] args) {

  }



  public TreeNode invertTree(TreeNode root) {

    //dfs swap tree child
    dfsSwapChild(root);

    //print node value from top to bottom level
    return root;
  }

  private void dfsSwapChild(TreeNode root) {



    if(Objects.isNull(root) || Objects.isNull(root.left) && Objects.isNull(root.right)){

      return;
    }

    //reverse left child
    dfsSwapChild(root.left);
    //reverse right child
    dfsSwapChild(root.right);

    TreeNode temp;
    temp = root.left;
    root.left = root.right;
    root.right = temp;

  }


  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

}
