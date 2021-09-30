package com.haothink.kuaishou;

import com.haothink.TreeNode;

/**
 * Created by wanghao on 2021/9/24
 * 基本思想是做post order的递归， 就是对左右子树寻找这个节点（或者公共祖先）是否存在， 如果左右都存在，就返回当前的root，如果左边或者右边不存在，那么就返回存在的那边
 * 递归，如果要对寻找这个节点或者是左右子树的公共祖先分别写两个函数， 那会比较麻烦。 实际上我们可以直接用lowestCommonAncestor作为递归函数， 如果root == p || root == q, 就返回root， 虽然在子树里面这样返回的不是公共祖先，但是递归退回去的时候，只要有前面的左右逻辑，还是对的。
 **/
public class LowestCommonAncestorOfABinaryTree {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if(null == root || (p == null && q == null)){
      return null;
    }

    if(root == p || root == q){
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left,p,q);
    TreeNode right = lowestCommonAncestor(root.right,p,q);

    if(null != left && null != right){
      return root;
    }
    return null != left ?left : right;
  }
}
