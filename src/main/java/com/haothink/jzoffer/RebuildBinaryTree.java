package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年06月14日 23:50
 * description:
 *
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *{3,9,20,15,7}
 *{9,3,15,20,7}
 *
 * 解题思路
 * 前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，左部分为树的左子树中序遍历结果，
 * 右部分为树的右子树中序遍历的结果。
 *
 * 由于中序遍历序列中，有1个数字是左子树结点的值，因此左子树总共有1个左子结点。同样，在前序遍历的序列中，
 * 根节点后面的1个数字就是1个左子树结点的值，再后面的所有数字都是右子树结点的值。这样我们就在前序遍历和
 * 中序遍历两个序列中，分别找到了左右子树对应的子序列。
 */
public class RebuildBinaryTree {



    public static void main(String[] args) {

        int[] preOrder = {3,9,20,15,7};
        int[] middleOrder = {9,3,15,20,7};



    }


    private static TreeNode constructBinaryTree(int[] preOrder,int[] middleOrder){

        return null;
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
