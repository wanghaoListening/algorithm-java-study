package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年09月01日 16:27
 * description: 二叉树的深度
 *
 * 题目描述：
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 *
 */
public class BiTreeDepth {


    public static void main(String[] args) {

        TreeNode node4 = new TreeNode();
        node4.value = 4;

        TreeNode node7 = new TreeNode();
        node7.value = 7;

        TreeNode node6 = new TreeNode();
        node6.value = 6;
        node6.left = node4;
        node6.right = node7;

        TreeNode node1 = new TreeNode();
        node1.value = 1;

        TreeNode node3 = new TreeNode();
        node3.value = 3;
        node3.left = node1;
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
        node8.left = node3;
        node8.right = node10;

        System.out.println(getTreeDepth(node8));
    }

    private static int getTreeDepth(TreeNode treeNode){

        return null == treeNode ? 0:1+Math.max(getTreeDepth(treeNode.left),getTreeDepth(treeNode.right));
    }
}
