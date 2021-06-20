package com.haothink.leetcode.tree_depth_first_search;

import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by wanghao on 2021-06-19
 *
 * Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
 *
 *
 **/
public class KthSmallestElementInABST {

  public static void main(String[] args) {

  }

  public int kthSmallest(TreeNode root, int k) {

    SortedSet<Integer> set = new TreeSet<>();

    dfsPreOrder(root,set,k);

    return set.last();
  }

  private void dfsPreOrder(TreeNode root, SortedSet<Integer> set,int k) {

    if(Objects.isNull(root)){

      return;
    }

    if(set.size() >= k){
      //remove the largest ele in the set
      if(root.val < set.last()){
        set.remove(set.last());
        set.add(root.val);
      }
    }else{
      set.add(root.val);
    }

    dfsPreOrder(root.left,set,k);
    dfsPreOrder(root.right,set,k);
  }


  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

}
