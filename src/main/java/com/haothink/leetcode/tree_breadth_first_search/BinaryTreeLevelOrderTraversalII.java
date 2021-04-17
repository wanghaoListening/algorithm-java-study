package com.haothink.leetcode.tree_breadth_first_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanghao on 2021-04-17
 **/
public class BinaryTreeLevelOrderTraversalII {


  public static void main(String[] args) {

  }


  public List<List<Integer>> levelOrderBottom(TreeNode root) {


    //使用队列进行广度优先遍历
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<TreeNode> queue = new LinkedList<>();

    if(Objects.isNull(root)){

      return Collections.emptyList();
    }
    //使用队列进行广度优先遍历
    queue.add(root);

    while (!queue.isEmpty()){

      int queueSize = queue.size();
      List<Integer> list = new ArrayList<>();
      for(int i=0;i<queueSize;i++) {
          //add
          TreeNode treeNode = queue.removeFirst();
          list.add(treeNode.val);

          if (Objects.nonNull(treeNode.left)) {
            queue.add(treeNode.left);
          }
          if (Objects.nonNull(treeNode.right)) {
            queue.add(treeNode.right);
          }

      }
      result.add(0,list);
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
