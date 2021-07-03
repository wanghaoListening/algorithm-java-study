package com.haothink.shoppe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanghao on 2021-07-03
 **/
public class BinaryTreePostorderTraversal {


  public static void main(String[] args) {

  }


  public List<Integer> postorderTraversal(TreeNode root) {

    List<Integer> results = new ArrayList<>();

    dfsPostOrderTraversal(root,results);

    return results;
  }


  public void dfsPostOrderTraversal(TreeNode root,List<Integer> results){
    if(Objects.isNull(root)){

      return;
    }
    dfsPostOrderTraversal(root.left,results);
    dfsPostOrderTraversal(root.right,results);
    results.add(root.val);
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
