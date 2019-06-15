package com.haothink;

/**
 * @author wanghao
 * @date 2019年06月14日 23:50
 * description:
 *
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 解题思路
 * 前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，左部分为树的左子树中序遍历结果，
 * 右部分为树的右子树中序遍历的结果。
 */
public class RebuildBinaryTree {


    public static void main(String[] args) {

        int[] preOrder = {3,9,20,15,7};
        int[] middleOrder = {9,3,15,20,7};



    }


    private static class TreeNode{

        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
