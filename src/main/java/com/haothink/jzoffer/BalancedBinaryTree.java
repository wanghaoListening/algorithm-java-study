package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年09月02日 20:09
 * description: 平衡二叉树
 *
 * 题目描述：
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 解题思路：
 * 由于平衡二叉树的左右子树的高度相差不大于1，所以我们可以分别计算左右子树的高度，然后进行比较。
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {

        TreeNode node4 = new TreeNode();
        node4.value = 4;

        TreeNode node7 = new TreeNode();
        node7.value = 7;

        TreeNode node6 = new TreeNode();
        node6.value = 6;
        node6.left = node4;
        node6.right = node7;

        TreeNode node3 = new TreeNode();
        node3.value = 3;
        node3.right = node6;

        TreeNode node13 = new TreeNode();
        node13.value = 13;

        TreeNode node14 = new TreeNode();
        node14.value = 14;
        node14.left = node13;

        TreeNode node10 = new TreeNode();
        node10.value = 10;
        node10.right = node14;

        TreeNode node8 = new TreeNode();
        node8.value = 8;
        node8.right = node10;

        System.out.println(isBalancedTree(node8));
    }



    private static boolean isBalancedTree(TreeNode treeNode){

        int leftDepth = depthOfTree(treeNode.left);
        int rightDepth = depthOfTree(treeNode.right);

        return Math.abs(leftDepth-rightDepth) <=1;
    }


    private static int depthOfTree(TreeNode treeNode){

        return null == treeNode?0:1+Math.max(depthOfTree(treeNode.left),depthOfTree(treeNode.right));
    }
}
