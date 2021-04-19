package com.haothink.leetcode.tree_depth_first_search;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanghao on 2021-04-18
 *
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths
 * where each path's sum equals targetSum.
 *
 * A leaf is a node with no children.
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 **/
public class PathSumII {


  public static void main(String[] args) {

  }


  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {


    List<List<Integer>> results = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    dfsFindPathSum(root,targetSum,results,list);

    return results;

  }

  public void dfsFindPathSum(TreeNode root, int targetSum,List<List<Integer>> sumList,List<Integer> list){

    if(Objects.isNull(root)){

      return;
    }

    if(Objects.isNull(root.left) && Objects.isNull(root.right) && root.val == targetSum){

      list.add(root.val);
      sumList.add(list);
      return;
    }

    list.add(root.val);
    dfsFindPathSum(root.left,targetSum-root.val,sumList,new ArrayList<>(list));
    dfsFindPathSum(root.right,targetSum-root.val,sumList,new ArrayList<>(list));
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
