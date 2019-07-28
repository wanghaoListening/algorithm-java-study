package com.haothink.jzoffer;

import java.util.Objects;
import java.util.Stack;

/**
 * @author wanghao
 * @date 2019年07月28日 11:25
 * description: 按之字形顺序打印二叉树
 *
 * 题目描述：
 *
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * 解题思路：
 * 利用栈的先进后出的思想，这里需要注意：出栈的节点，先放左孩子再放右孩子，那么下一层出栈的节点就应该先放右孩子再放左孩子，重复上述过程即可。
 */
public class BiTreePrintByZPattern {

    public static void main(String[] args) {

        TreeNode root = new TreeNode();
        root.value = 8;

        root.right = new TreeNode();
        root.right.value = 7;

        root.left = new TreeNode();
        root.left.value = 8;

        root.left.left = new TreeNode();
        root.left.left.value = 9;

        root.left.right = new TreeNode();
        root.left.right.value = 2;

        root.left.right.left = new TreeNode();
        root.left.right.left.value = 5;
        root.left.right.left.left = new TreeNode();
        root.left.right.left.left.value = 4;
        root.left.right.left.right = new TreeNode();
        root.left.right.left.right.value = 7;

        printTree(root);

    }


    private static void printTree(TreeNode root){

        if(Objects.isNull(root)){
            return;
        }

        Stack<TreeNode> oddStack = new Stack<>();
        Stack<TreeNode> evenStack = new Stack<>();

        oddStack.push(root);
        Stack<TreeNode> stack = oddStack;

        int count = 1;

        while (!stack.isEmpty()){

            count++;
            int size = stack.size();
            for(int i=0;i<size;i++){

                TreeNode treeNode = stack.pop();
                System.out.print(treeNode.value+" ");
                if(count % 2 == 0){
                    if(Objects.nonNull(treeNode.left)){
                        evenStack.push(treeNode.left);
                    }
                    if(Objects.nonNull(treeNode.right)){
                        evenStack.push(treeNode.right);
                    }
                }else {
                    if(Objects.nonNull(treeNode.right)){
                        oddStack.push(treeNode.right);
                    }
                    if(Objects.nonNull(treeNode.left)){
                        oddStack.push(treeNode.left);
                    }
                }
            }
            System.out.println();
            if(count % 2 == 0){
              stack = evenStack;
            }else {
               stack = oddStack;
            }

        }

    }
}
