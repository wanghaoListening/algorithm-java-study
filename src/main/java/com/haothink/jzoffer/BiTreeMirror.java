package com.haothink.jzoffer;

import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年07月20日 16:18
 * description: 二叉树的镜像
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 解题思路：
 * 先前序遍历这棵树的每个节点，如果遍历到的节点有子节点，就交换它的两个子节点。当交换完所有非叶节点的左、右子节点之后，就得到了树的镜像。
 */
public class BiTreeMirror {


    /**
     * 输入一棵数的头结点
     * @param head
     *        头结点
     */
    private static void mirror(TreeNode head){

        if(Objects.isNull(head)){
            return;
        }

        if(Objects.isNull(head.left) && Objects.isNull(head.right)){
            return;
        }

        TreeNode tempNode = head.left;
        head.left = head.right;
        head.right = tempNode;

        mirror(head.left);
        mirror(head.right);
    }

}
