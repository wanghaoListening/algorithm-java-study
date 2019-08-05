package com.haothink.jzoffer;

import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年08月02日 17:45
 * description: 序列化二叉树
 *
 * 题目描述：
 * 设计一个算法能够实现序列化和反序列化一棵二叉树（注意，不是二叉搜索树BST）。这里的序列化指的是将一棵二叉树保存到文件中，反序列化就是从文件中读取二叉树结点值重构原来的二叉树。
 *
 * 解题思路：
 *
 *
 */
public class BiTreeSerializeAndDeserialize {


    private static String treeStr;


    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;

        String serializeStr = serialize(n1);
        System.out.println(serializeStr);

        TreeNode treeNode = deserialize(serializeStr);
        printTree(treeNode);
    }

    //对搜索二叉树进行中序遍历
    private static void printTree(TreeNode treeNode){

        if(Objects.isNull(treeNode)){
            return;
        }
        System.out.print(treeNode.value+" ");
        printTree(treeNode.left);
        printTree(treeNode.right);
    }




    public static String serialize(TreeNode root){

        if(Objects.isNull(root)){
            return "#";
        }
        return root.value+","+serialize(root.left)+","+serialize(root.right);
    }

    public static TreeNode deserialize(String str){

        if(Objects.isNull(str) || str.length() <=0){
            return null;
        }

        int index = str.indexOf(",");
        String value = (index == -1)?str:str.substring(0,index);
        treeStr = (index == -1)?"":str.substring(index+1);

        if("#".equals(value)){
            return null;
        }

        TreeNode treeNode = new TreeNode();
        treeNode.value = Integer.valueOf(value);
        treeNode.left = deserialize(treeStr);
        treeNode.right = deserialize(treeStr);
        return treeNode;
    }


}
