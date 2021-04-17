package com.haothink.leetcode.tree_breadth_first_search;


import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by wanghao on 2021-04-17
 *
 *You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
 * The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer
 * should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 **/
public class PopulatingNextRightPointersInEachNode {


  public static void main(String[] args) {


  }



  public Node connect(Node root) {


    //使用队列进行广度优先遍历
    LinkedList<Node> queue = new LinkedList<>();

    if(Objects.isNull(root)){

      return root;
    }
    queue.add(root);

    while (!queue.isEmpty()){

      int queueSize = queue.size();
      for(int i=0;i<queueSize;i++) {
        //add
        Node node = queue.removeFirst();
        //check size because of perfect binary tree
        if(i < queueSize-1){
          node.next = queue.getFirst();
        }else {
          node.next = null;
        }
        queue.add(node.left);
        queue.add(node.right);

      }
    }
    return root;
  }



  static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  };

}
