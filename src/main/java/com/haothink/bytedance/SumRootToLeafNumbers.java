package com.haothink.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghao on 2021/9/2
 *
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A leaf node is a node with no children.
 *
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 **/
public class SumRootToLeafNumbers {


  public static void main(String[] args) {

    TreeNode treeNode = new TreeNode(1);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(3);
    treeNode.left = left;
    treeNode.right = right;

    SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
    System.out.println(sumRootToLeafNumbers.sumNumbers(treeNode));

  }

  public int sumNumbers(TreeNode root) {

    //深度遍历所有path
    List<Integer> numberList = new ArrayList<>();
    dfs(root,root.val,numberList);
    //求和sum
    return numberList.stream().mapToInt(Integer::intValue).sum();
  }


  private void dfs(TreeNode root,int number, List<Integer> numberList){

    if(null == root.left && null == root.right){
      //end
      numberList.add(number);
      return;
    }
    if(null != root.left) {
      dfs(root.left, number*10+root.left.val,numberList);
    }
    if(null != root.right){
      dfs(root.right, number*10+root.right.val,numberList);
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
