package com.haothink.shoppe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanghao on 2021-06-28
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 **/
public class BinaryTreeInorderTraversal {

  public List<Integer> inorderTraversal(TreeNode root) {

    List<Integer> results = new ArrayList<>();


    dfsInOrder(root,results);

    return results;
  }

  private void dfsInOrder(TreeNode root,List<Integer> results){

    if(Objects.isNull(root)){

      return;
    }

    dfsInOrder(root.left,results);
    results.add(root.val);
    dfsInOrder(root.right,results);
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
