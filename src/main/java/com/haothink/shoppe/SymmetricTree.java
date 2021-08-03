package com.haothink.shoppe;

import java.util.Objects;

/**
 * Created by wanghao on 2021-07-13
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 **/
public class SymmetricTree {

  public static void main(String[] args) {

  }

  public boolean isSymmetric(TreeNode root) {



    return isSymmetricTree(root.left,root.right);
  }


  public boolean isSymmetricTree(TreeNode left,TreeNode right){

    if(Objects.isNull(left) && Objects.isNull(right)){

      return true;
    }
    if(Objects.isNull(left) || Objects.isNull(right)){

      return false;
    }
    if(left.val != right.val){
      return false;
    }
    return isSymmetricTree(left.left,right.right) && isSymmetricTree(left.right,right.left);
  }



  public class TreeNode {
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
