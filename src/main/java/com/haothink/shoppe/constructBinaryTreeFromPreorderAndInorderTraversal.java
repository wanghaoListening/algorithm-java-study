package com.haothink.shoppe;


/**
 * Created by wanghao on 2021/7/30 mail:hellotime@gmail.com
 *
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 **/
public class constructBinaryTreeFromPreorderAndInorderTraversal {


  public static void main(String[] args) {

    int[] preorder = {3,9,20,15,7};
    int[] inorder = {9,3,15,20,7};

    constructBinaryTreeFromPreorderAndInorderTraversal cbt =  new constructBinaryTreeFromPreorderAndInorderTraversal();
    TreeNode root = cbt.buildTree(preorder,inorder);
    System.out.println(root);
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {

    return constructTree(0,0,inorder.length,preorder,inorder);
  }

  private TreeNode constructTree(int rootIndex, int startIndex,int endIndex,int[] preorder, int[] inorder) {

    if(startIndex >= endIndex){
      return null;
    }

    int splitIndex = getArrayIndex(inorder,preorder[rootIndex]);
    TreeNode root = new TreeNode(preorder[rootIndex]);
    TreeNode left = constructTree(rootIndex+1,startIndex,splitIndex,preorder,inorder);
    TreeNode right = constructTree(splitIndex+1,splitIndex+1,endIndex,preorder,inorder);
    root.left = left;
    root.right = right;
    return root;
  }



  private int getArrayIndex(int[] arr,int value) {

    int k=0;
    for(int i=0;i<arr.length;i++){

      if(arr[i]==value){
        k=i;
        break;
      }
    }
    return k;
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
