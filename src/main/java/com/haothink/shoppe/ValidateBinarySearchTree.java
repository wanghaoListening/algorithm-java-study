package com.haothink.shoppe;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanghao on 2021/8/8 mail:hiwanghao@didiglobal.com
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Input: root = [2,1,3]
 * Output: true
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 **/
public class ValidateBinarySearchTree {

  public static void main(String[] args) {

  }

  public boolean isValidBST(TreeNode root){

    List<Integer>numList = new ArrayList<>();
    dfsBST(numList,root);
    int beforeIndex = 0;
    int afterIndex = 1;
    while (afterIndex <= numList.size()-1){

      if(numList.get(afterIndex) <= numList.get(beforeIndex)){

        return false;
      }
      beforeIndex++;
      afterIndex++;
    }
    return true;
  }

  private void dfsBST(List<Integer> numList, TreeNode root){

    if(Objects.isNull(root)){
      return;
    }
    dfsBST(numList,root.left);
    numList.add(root.val);
    dfsBST(numList,root.right);
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
