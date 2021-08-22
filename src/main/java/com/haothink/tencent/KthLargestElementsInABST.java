package com.haothink.tencent;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanghao on 2021/8/22
 *
 *
 **/
public class KthLargestElementsInABST {

  public static void main(String[] args) {

  }


  public int kthLargest(TreeNode root,int k){

    List<Integer> valList = new ArrayList<>();
    preOrderDfs(root,valList);
    return valList.get(valList.size()-k-1);
  }

  private void preOrderDfs(TreeNode root,List<Integer> valList){

    if(Objects.isNull(root)){
      return;
    }
    preOrderDfs(root.left,valList);
    valList.add(root.val);
    preOrderDfs(root.right,valList);
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
