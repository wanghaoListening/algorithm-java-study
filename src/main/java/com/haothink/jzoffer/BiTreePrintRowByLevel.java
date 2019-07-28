package com.haothink.jzoffer;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author wanghao
 * @date 2019年07月25日 19:58
 * description: 把二叉树打印成多行
 *
 * 描述:
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 *
 */
public class BiTreePrintRowByLevel {

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

        Queue<TreeNode> oddQuene = new LinkedList<>();
        Queue<TreeNode> evenQuene = new LinkedList<>();
        
        
        oddQuene.offer(root);
        Queue<TreeNode> queue = oddQuene;
        
        int count = 1;
        
        while (!queue.isEmpty()){
            
            int size = queue.size();
            count++;
            for(int i=0;i<size;i++){

                TreeNode treeNode = queue.poll();
                System.out.print(treeNode.value+" ");
                if(count % 2 == 0){
                    if(Objects.nonNull(treeNode.left)){
                        evenQuene.offer(treeNode.left);
                    }
                    if(Objects.nonNull(treeNode.right)){
                        evenQuene.offer(treeNode.right);
                    }
                    
                }else {
                    if(Objects.nonNull(treeNode.left)){
                        oddQuene.offer(treeNode.left);
                    }
                    if(Objects.nonNull(treeNode.right)){
                        oddQuene.offer(treeNode.right);
                    }
                }

            }

            System.out.println();
            
            queue = count % 2 == 0?evenQuene:oddQuene;
        }
        
    }

}
