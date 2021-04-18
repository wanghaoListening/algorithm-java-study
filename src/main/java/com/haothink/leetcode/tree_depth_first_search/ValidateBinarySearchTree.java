package com.haothink.leetcode.tree_depth_first_search;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanghao on 2021-04-18
 *
 *Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * 识别树形DFS：
 *
 * 你需要按前中后序的DFS方式遍历树
 * 如果该问题的解一般离叶子节点比较近。
 *
 * 二分查找树，中序遍历的序列是有序的
 **/
public class ValidateBinarySearchTree {


  public static void main(String[] args) {

    TreeNode five = new TreeNode(2);
    TreeNode four = new TreeNode(1);
    TreeNode six = new TreeNode(3);
    TreeNode three = new TreeNode(3);
    TreeNode seven = new TreeNode(6);

    five.left = four;
    five.right = six;

    //six.left = three;
    //six.right = seven;


    ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();

    System.out.println(validateBinarySearchTree.isValidBST(five));



  }


  public boolean isValidBST(TreeNode root) {


    List<Integer> results = new ArrayList<>();

    dfs(root,results);

    int globalCurValue = results.get(0);
    for(int i=1;i<results.size();i++){

      int curr = results.get(i);

      if(curr > globalCurValue){
        globalCurValue = curr;
      }else {
        return false;
      }
    }

    return true;
  }

  public void dfs(TreeNode root,List<Integer> results){

    if(Objects.nonNull(root)){

      dfs(root.left,results);
      results.add(root.val);
      dfs(root.right,results);

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
