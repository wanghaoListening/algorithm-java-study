package com.haothink;

import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年06月20日 22:57
 * description:
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 *
 * 解题思路
 * 1.如果一个结点有右子树，那么它的下一个结点就是它的右子树中的左子结点。也就是说右子结点出发一
 * 直沿着指向左子结点的指针，我们就能找到它的下一个结点。
 *
 * 接着我们分析一个结点没有右子树的情形。如果结点是它父节点的左子结点，那么它的下一个结点就是它的父结点。
 *
 * 如果一个结点既没有右子树，并且它还是它父结点的右子结点，这种情形就比较复杂。我们可以沿着指向父节点的
 * 指针一直向上遍历，直到找到一个是它父结点的左子结点的结点。如果这样的结点存在，那么这个结点的父结点就
 * 是我们要找的下一个结点。
 */
public class SelectBinaryTreeNode {


    public static void main(String[] args) {

    }

    private static TreeNode searchNextNode(TreeNode currentNode){

        if(Objects.nonNull(currentNode.right)){

            TreeNode leftNode = currentNode.right.left;
            while (Objects.nonNull(leftNode)){
                leftNode = leftNode.left;
                if(Objects.isNull(leftNode.left)){
                    return leftNode;
                }
            }
        }

        TreeNode parantNode = currentNode.parent;
        TreeNode curNode = currentNode;
        while (Objects.nonNull(parantNode) && parantNode.left != curNode){
            curNode = parantNode;
            parantNode = parantNode.parent;

        }

        return parantNode;
    }



    private static class TreeNode{

        private int value;

        private TreeNode parent;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(TreeNode parent, TreeNode left, TreeNode right,int value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.value = value;
        }


        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    '}';
        }
    }
}
