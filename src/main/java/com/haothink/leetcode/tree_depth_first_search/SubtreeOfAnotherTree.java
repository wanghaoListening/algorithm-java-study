package com.haothink.leetcode.tree_depth_first_search;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanghao on 2021-06-24 mail
 *
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the
 * same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
 * The tree tree could also be considered as a subtree of itself.
 **/
public class SubtreeOfAnotherTree {

  public static void main(String[] args) {

  }



  public boolean isSubtree(TreeNode root, TreeNode subRoot) {

    List<TreeNode> treeNodeList = new ArrayList<>();

    findNode(root,subRoot,treeNodeList);

    for(TreeNode sameRoot : treeNodeList){

      boolean result = preOrderCompareNode(sameRoot,subRoot);
      if(result){
        return true;
      }
    }

    return false;
  }

  private void findNode(TreeNode root, TreeNode subRoot, List<TreeNode> treeNodeList){

    if(Objects.isNull(root)){

      return;
    }

    if(root.val == subRoot.val){

      treeNodeList.add(root);
    }
    findNode(root.left,subRoot,treeNodeList);
    findNode(root.right,subRoot,treeNodeList);
  }

  private boolean preOrderCompareNode(TreeNode root, TreeNode subRoot){

    if(Objects.isNull(root) && Objects.isNull(subRoot)){

      return true;
    }else if(Objects.nonNull(root) && Objects.nonNull(subRoot)){
      if(root.val != subRoot.val){
        return false;
      }
      return preOrderCompareNode(root.left,subRoot.left) && preOrderCompareNode(root.right,subRoot.right);
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
