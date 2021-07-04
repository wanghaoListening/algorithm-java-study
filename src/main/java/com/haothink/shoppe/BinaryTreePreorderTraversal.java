package com.haothink.shoppe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanghao on 2021-07-04
 *
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 **/
public class BinaryTreePreorderTraversal {


  public static void main(String[] args) {

  }

  public List<Integer> preorderTraversal(TreeNode root) {

    List<Integer> result = new ArrayList<>();

    dfsPreorder(root,result);
    return result;
  }

  private void dfsPreorder(TreeNode root,List<Integer> result){

    if(Objects.isNull(root)){

      return;
    }

    result.add(root.val);
    dfsPreorder(root.left,result);
    dfsPreorder(root.right,result);
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
