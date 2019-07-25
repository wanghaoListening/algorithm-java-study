package com.haothink.jzoffer;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author wanghao
 * @date 2019年07月25日 19:17
 * description: 从上往下打印二叉树
 *
 * 题目描述：
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 思想：
 * 利用队列，首先将根节点入队，出队后打印根节点然后将根节点的左右子树入队，然后继续从队列出节点依次执行此操作.
 */
public class BiTreePrintByLevel {


    private static Queue<TreeNode> queue = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode();
        root1.value = 8;

        root1.right = new TreeNode();
        root1.right.value = 7;

        root1.left = new TreeNode();
        root1.left.value = 8;

        root1.left.left = new TreeNode();
        root1.left.left.value = 9;

        root1.left.right = new TreeNode();
        root1.left.right.value = 2;

        root1.left.right.left = new TreeNode();
        root1.left.right.left.value = 5;
        root1.left.right.left.left = new TreeNode();
        root1.left.right.left.left.value = 4;
        root1.left.right.left.right = new TreeNode();
        root1.left.right.left.right.value = 7;

        printTree(root1);
    }

    private static void printTree(TreeNode root){


        if(Objects.isNull(root)){
            return;
        }
        queue.offer(root);
        TreeNode treeNode;
        while (Objects.nonNull(queue.peek())){
            treeNode = queue.poll();
            System.out.print(treeNode.value+"，");
            if(Objects.nonNull(treeNode.left)) {
                queue.offer(treeNode.left);
            }
            if(Objects.nonNull(treeNode.right)) {
                queue.offer(treeNode.right);
            }
        }
    }
}
