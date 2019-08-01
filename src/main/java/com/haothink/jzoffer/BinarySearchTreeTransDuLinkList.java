package com.haothink.jzoffer;

import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年08月01日 18:34
 * description:二叉搜索树与双向链表
 *
 * 题目描述：
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 解题思路：
 * 二叉搜索树的中序遍历是排序的，所以可以用中序遍历递归的方式，在遍历的过程中拼接双向链表，这里需要注意：当遍历完根节点的左子树的时候需要
 * 有一个指针来记录左子树中序遍历的最后一个节点。然后与根节点链接。
 */
public class BinarySearchTreeTransDuLinkList {

    private static TreeNode head = null;
    private static TreeNode pre = null;


    public static void main(String[] args) {
        TreeNode node10 = new TreeNode();
        node10.value = 10;
        TreeNode node6 = new TreeNode();
        node6.value = 6;
        TreeNode node14 = new TreeNode();
        node14.value = 14;
        TreeNode node4 = new TreeNode();
        node4.value = 4;
        TreeNode node8 = new TreeNode();
        node8.value = 8;
        TreeNode node12 = new TreeNode();
        node12.value = 12;
        TreeNode node16 = new TreeNode();
        node16.value = 16;
        node10.left = node6;
        node10.right = node14;
        node6.left = node4;
        node6.right = node8;
        node14.left = node12;
        node14.right = node16;
        System.out.println("Before convert: =========");
        printTree(node10);
        TreeNode head = covert(node10);
        System.out.println("After convert : =========");
        printList(head);
    }

    private static void printList(TreeNode treeNode){

        while (Objects.nonNull(treeNode)){

            System.out.println(treeNode.value);
            treeNode = treeNode.right;
        }
    }

    //对搜索二叉树进行中序遍历
    private static void printTree(TreeNode treeNode){

        if(Objects.isNull(treeNode)){
            return;
        }
        printTree(treeNode.left);
        System.out.println(treeNode.value);
        printTree(treeNode.right);
    }

    private static TreeNode covert(TreeNode treeNode){

        inOrder(treeNode);
        return head;

    }

    private static void inOrder(TreeNode treeNode){

        if(Objects.isNull(treeNode)){
            return;
        }
        inOrder(treeNode.left);
        treeNode.left = pre;
        if(Objects.nonNull(pre)){
            pre.right = treeNode;

        }
        pre = treeNode;
        inOrder(treeNode.right);
        if(Objects.isNull(head)){
            head = treeNode;
        }
    }


}
