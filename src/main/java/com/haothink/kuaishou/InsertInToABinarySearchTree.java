package com.haothink.kuaishou;

import com.haothink.TreeNode;

/**
 * Created by wanghao on 2021/10/11
 *
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree.
 * Return the root node of the BST after the insertion. It is guaranteed that the new value does
 * not exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains
 * a BST after insertion. You can return any of them.
 **/
public class InsertInToABinarySearchTree {

  //Time Limit Exceeded
  public TreeNode insertIntoBST(TreeNode root, int val) {

    //dfsInsert(root,val);

    TreeNode currNode = root;

    while (null != currNode){

      if(null == currNode.left && null == currNode.right){
        //this is leaf node
        if(currNode.val > val){
          currNode.left = new TreeNode(val);
        }else {
          currNode.right = new TreeNode(val);
        }
        break;
      }

      if(root.val > val){
        //go to left tree
        currNode = root.left;
      }else {
        //go to right tree
        currNode = root.right;
      }
    }

    return root;
  }


  //Memory Limit Exceeded
  public void dfsInsert(TreeNode root, int val){

    if(null == root){
      return;
    }
    if(null == root.left && null == root.right){
      //this is leaf node
      if(root.val > val){
        root.left = new TreeNode(val);
      }else {
        root.right = new TreeNode(val);
      }
    }

    if(root.val > val){
      //go to left tree
      dfsInsert(root.left,val);
    }else {
      //go to right tree
      dfsInsert(root.right,val);
    }
  }
}
