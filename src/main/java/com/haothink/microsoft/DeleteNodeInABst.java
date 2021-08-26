package com.haothink.microsoft;


import java.util.Objects;

/**
 * Created by wanghao on 2021/8/25
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Follow up: Can you solve it with time complexity O(height of tree)?
 *
 * Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 *
 * 首先分析所有的case
 * reference ： https://zxi.mytechroad.com/blog/tree/leetcode-450-delete-node-in-a-bst/
 *
 *
 **/
public class DeleteNodeInABst {


  public static void main(String[] args) {

  }

  public TreeNode deleteNode(TreeNode root, int key) {

    if (root == null) return root;
    if (key > root.val) {
      root.right = deleteNode(root.right, key);
    } else if (key < root.val) {
      root.left = deleteNode(root.left, key);
    } else {
      if (root.left != null && root.right != null) {
        TreeNode min = root.right;
        while (min.left != null) min = min.left;
        root.val = min.val;
        root.right = deleteNode(root.right, min.val);
      } else {
        TreeNode newRoot = root.left == null ? root.right:root.left;
        root.left = root.right = null;
        return newRoot;
      }
    }
    return root;
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
