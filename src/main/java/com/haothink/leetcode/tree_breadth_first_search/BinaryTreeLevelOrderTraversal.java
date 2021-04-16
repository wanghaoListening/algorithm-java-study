package com.haothink.leetcode.tree_breadth_first_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * Created by wanghao on 2021-04-16
 *
 * Given the root of a binary tree, return the level order traversal of
 * its nodes' values. (i.e., from left to right, level by level).
 *
 * 利用bfs广度优先搜索遍历二叉树每一行，如果当前行是偶数行，则正序向返回结果插入数据，
 * 反之则逆序插入。bfs的部分完全是模板级别的代码，这里就不在多说了。
 **/
public class BinaryTreeLevelOrderTraversal {


  public static void main(String[] args) {



  }



  public List<List<Integer>> levelOrder(TreeNode root) {

    Queue<TreeNode> queue ;

    if(Objects.isNull(root)){

      return Collections.emptyList();
    }

    //使用队列进行广度优先遍历
    List<List<Integer>> result = new ArrayList<>();

    Queue<TreeNode> oddQueue = new LinkedList<>();
    Queue<TreeNode> evenQueue = new LinkedList<>();

    oddQueue.add(root);
    queue = oddQueue;

    int count = 0;
    while (!queue.isEmpty()){

      count ++;

      if(count % 2 == 1){
        //odd
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
          TreeNode treeNode = queue.poll();
          list.add(treeNode.val);

          if(Objects.nonNull(treeNode.left)) {
            evenQueue.add(treeNode.left);
          }
          if(Objects.nonNull(treeNode.right)) {
            evenQueue.add(treeNode.right);
          }
        }
        result.add(list);
        queue = evenQueue;
      }

      if(count % 2 == 0){
        //even
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
          TreeNode treeNode = queue.poll();
          list.add(treeNode.val);

          if(Objects.nonNull(treeNode.left)) {
            oddQueue.add(treeNode.left);
          }
          if(Objects.nonNull(treeNode.right)) {
            oddQueue.add(treeNode.right);
          }
        }
        result.add(list);
        queue = oddQueue;
      }
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
