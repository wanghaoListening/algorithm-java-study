package com.haothink.shoppe;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Created by wanghao on 2021-07-12
 *
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 *
 * Input: root = [2,1,3]
 * Output: 1
 *
 * 解题思路：
 * 层次遍历二叉树，记录每行开头的元素
 *
 * 需要额外两个变量，一个变量用来保存当前层 还未打印的结点个数，另一个变量保存下一层待打印的结点个数。
 **/
public class FindBottomLeftTreeValue {


  public static void main(String[] args) {

    TreeNode root = new TreeNode(2);
    TreeNode left = new TreeNode(1);
    TreeNode right = new TreeNode(3);

    root.left = left;
    root.right = right;

    FindBottomLeftTreeValue findBottomLeftTreeValue = new FindBottomLeftTreeValue();
    System.out.println(findBottomLeftTreeValue.findBottomLeftValue(root));

  }


  public int findBottomLeftValue(TreeNode root) {

    Queue<TreeNode> queue = new LinkedList<>();

    int current = 1;
    int next = 0;
    int leftValue = root.val;
    queue.offer(root);

    while (!queue.isEmpty()){

      TreeNode queueHead = queue.poll();
      current--;

      if(Objects.nonNull(queueHead.left)){
        queue.offer(queueHead.left);
        next++;
      }
      if(Objects.nonNull(queueHead.right)){
        queue.offer(queueHead.right);
        next++;
      }
      if(current == 0){
        if(!queue.isEmpty()) leftValue = queue.peek().val;
        current = next;
        next = 0;
      }
    }
    return leftValue;
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
