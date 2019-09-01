package com.haothink.jzoffer;


/**
 * @author wanghao
 * @date 2019年09月01日 14:54
 * description: 二叉查找树的第 K 个结点
 *
 * 题目描述：
 * 给定一颗二叉搜索树，请找出其中的第k小的结点。
 *
 * 如图：http://wanghao-github-blog.test.upcdn.net/upaiyun/swordoffer/bst-bitree.png，第三个节点为4
 *
 *
 *
 * 解题思路：
 * 由于二叉搜索树的中序序列是一个有序的序列，所以按照中序序列遍历过程进行节点统计即可。
 *
 *
 */
public class KNodeOfBinarySearchTree {

    private static int counter = 0;

    private static TreeNode kNode;

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

        System.out.println(getKTreeNode(node8,4).getValue());


    }


    private static TreeNode getKTreeNode(TreeNode treeNode,int k){
        middleFind(treeNode,k);
        return kNode;
    }

    private static void middleFind(TreeNode treeNode,int k){

        if(null == treeNode){
            return;
        }
        middleFind(treeNode.left,k);
        counter++;
        if(counter == k){
            kNode = treeNode;
            return ;
        }
        middleFind(treeNode.right,k);

    }
}
