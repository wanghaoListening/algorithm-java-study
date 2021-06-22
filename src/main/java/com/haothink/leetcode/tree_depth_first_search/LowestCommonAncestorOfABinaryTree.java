package com.haothink.leetcode.tree_depth_first_search;

import java.util.Objects;

/**
 * Created by wanghao on 2021-06-21
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
 * nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node
 * to be a descendant of itself).”
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 * 这个题的模式叫做devide and conquer. 如果当前节点等于其中的p和q某一个节点，那么找到了节点，返回该节点，否则在左右子树分别寻找。
 *
 * 左右子树两个返回的是什么呢？按照该递归函数的定义，即找到了左子树和右子树里p和q的公共祖先，注意祖先可以是节点自己。然后根据左右侧找到的节点做进一步的判断。
 *
 * 如果左右侧查找的结果都不为空，说明分别找到了p和q，那么LCA就是当前节点。否则就在不为空的那个结果就是所求。
 *
 **/
public class LowestCommonAncestorOfABinaryTree {


  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if(Objects.isNull(root)){

      return null;
    }

    if(root.val == p.val || root.val == q.val){

      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left,p,q);
    TreeNode right = lowestCommonAncestor(root.right,p,q);

    if(Objects.nonNull(left) && Objects.nonNull(right)){

      return root;
    }

    return Objects.nonNull(left) ? left:right;

  }



  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
