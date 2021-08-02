package com.haothink.shoppe;


import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Created by wanghao on 2021/8/2 mail:hiwanghao@didiglobal.com
 *
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next
 * node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 *
 * 1.首先先序遍历将节点放入队列当中
 * 2.打印队列元素构造列表
 **/
public class FlattenBinaryTreeToLinkedList {


  public static void main(String[] args) {


  }

  public void flatten(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    preOrderTree(queue,root);

    TreeNode returnRootTree = queue.poll();
    while (!queue.isEmpty()){
      returnRootTree.left = null;
      returnRootTree.right = queue.poll();
      returnRootTree = returnRootTree.right;
    }

  }

  public void preOrderTree(Queue<TreeNode> queue,TreeNode root){

    if(Objects.isNull(root)){
      return;
    }
    queue.offer(root);

    if(Objects.nonNull(root.left)){
      preOrderTree(queue,root.left);
    }
    if(Objects.nonNull(root.right)){
      preOrderTree(queue,root.right);
    }
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
