package com.haothink.shoppe;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanghao on 2021/8/2 mail:hiwanghao@didiglobal.com
 *
 * Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 **/
public class KthSmallestElementInABST {


  private static int count = 1;

  public static void main(String[] args) {

  }


  public int kthSmallest(TreeNode root, int k) {

    List<TreeNode> treeNodeList = new ArrayList<>();
    middleOrderTree(root,treeNodeList,k);
    return treeNodeList.get(k-1).val;
  }

  private void middleOrderTree(TreeNode root,List<TreeNode> treeNodeList,int k){

    if(treeNodeList.size() >= k){
      return;
    }
    if(Objects.isNull(root)){
      return;
    }
    if(Objects.nonNull(root.left)){
      middleOrderTree(root.left,treeNodeList,k);
    }
    treeNodeList.add(root);
    if(Objects.nonNull(root.right)){
      middleOrderTree(root.right,treeNodeList,k);
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
