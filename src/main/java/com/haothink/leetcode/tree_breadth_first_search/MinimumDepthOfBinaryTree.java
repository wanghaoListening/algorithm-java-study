package com.haothink.leetcode.tree_breadth_first_search;


import java.util.LinkedList;

import java.util.Objects;

/**
 * Created by wanghao on 2021-04-17
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 **/
public class MinimumDepthOfBinaryTree {


  public static void main(String[] args) {

  }



  public int minDepth(TreeNode root) {


    LinkedList<TreeNode> queue = new LinkedList<>();

    if(Objects.isNull(root)){

      return 0;
    }
    //使用队列进行广度优先遍历
    queue.add(root);
    int level = 0;
    while (!queue.isEmpty()){

      int queueSize = queue.size();
      level++;
      for(int i=0;i<queueSize;i++) {
        //add
        TreeNode treeNode = queue.removeFirst();

        if(Objects.isNull(treeNode.left)&& Objects.isNull(treeNode.right)){
          return level;
        }else {

          if (Objects.nonNull(treeNode.left)) {
            queue.add(treeNode.left);
          }
          if (Objects.nonNull(treeNode.right)) {
            queue.add(treeNode.right);
          }
        }

      }

    }
    return level;
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
