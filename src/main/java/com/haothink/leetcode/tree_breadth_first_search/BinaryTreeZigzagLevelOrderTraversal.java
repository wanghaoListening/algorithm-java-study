package com.haothink.leetcode.tree_breadth_first_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


/**
 * Created by wanghao on 2021-04-16 mail:
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 **/
public class BinaryTreeZigzagLevelOrderTraversal {


  public static void main(String[] args) {

    System.out.println(1%2);
  }


  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

    //使用队列进行广度优先遍历
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<TreeNode> queue = new LinkedList<>();

    if(Objects.isNull(root)){

      return Collections.emptyList();
    }
    //使用队列进行广度优先遍历
    queue.add(root);

    int count = 0;
    while (!queue.isEmpty()){

      int queueSize = queue.size();
      List<Integer> list = new ArrayList<>();
      count ++;
      for(int i=0;i<queueSize;i++) {

        if (count % 2 == 1) {
          //add
          TreeNode treeNode = queue.removeFirst();
          list.add(treeNode.val);

          if (Objects.nonNull(treeNode.left)) {
            queue.add(treeNode.left);
          }
          if (Objects.nonNull(treeNode.right)) {
            queue.add(treeNode.right);
          }

        }else{
          //even
          TreeNode treeNode = queue.removeLast();
          list.add(treeNode.val);

          if (Objects.nonNull(treeNode.right)) {
            queue.addFirst(treeNode.right);
          }
          if (Objects.nonNull(treeNode.left)) {
            queue.addFirst(treeNode.left);
          }
        }
      }
      result.add(list);
    }
    return result;
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
