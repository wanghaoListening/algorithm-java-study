package com.haothink.leetcode.tree_breadth_first_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanghao on 2021-04-17
 *
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 **/
public class BinaryTreeRightSideView {


  public static void main(String[] args) {

  }




  public List<Integer> rightSideView(TreeNode root) {


    //使用队列进行广度优先遍历
    List<Integer> result = new ArrayList<>();
    LinkedList<TreeNode> queue = new LinkedList<>();

    if(Objects.isNull(root)){

      return Collections.emptyList();
    }
    queue.add(root);

    while (!queue.isEmpty()){

      int queueSize = queue.size();

      for(int i=0;i<queueSize;i++) {
        //add
        TreeNode treeNode = queue.removeFirst();
        if(i == queueSize-1) {
          //the vary right node
          result.add(treeNode.val);
        }

        if (Objects.nonNull(treeNode.left)) {
          queue.add(treeNode.left);
        }
        if (Objects.nonNull(treeNode.right)) {
          queue.add(treeNode.right);
        }

      }
    }
    return result;
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
