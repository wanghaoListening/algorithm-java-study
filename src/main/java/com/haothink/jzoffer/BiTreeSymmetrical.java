package com.haothink.jzoffer;


/**
 * @author wanghao
 * @date 2019年07月21日 10:03
 * description: 对称的二叉树
 *
 * 请实现一个函数来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 *
 * 解题思路：
 *
 * 思路一：
 * 这个题最容易想到的方法就是，先将二叉树转换成镜像二叉树，再将镜像二叉树与自身一同遍历做对比。
 *
 * 思路二：
 * 解题的思路主要是运用递归的思想，即递归的判断左子树的左结点和右子树的右结点，当其都存在但不相
 * 等或者其中一个结点存在而另一个结点为
 * 空时则肯定不是对称二叉树 ，否则的话当两个节点同时为空时直接判定为此子数为对称二叉树。
 *
 */
public class BiTreeSymmetrical {


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(0);
        TreeNode leftNode = new TreeNode(1);
        TreeNode rightNode = new TreeNode(1);
        TreeNode leftNode1 = new TreeNode(2);
        TreeNode leftNode2 = new TreeNode(3);
        TreeNode rightNode1 = new TreeNode(3);
        TreeNode rightNode2 = new TreeNode(2);

        treeNode.left = leftNode;
        treeNode.right = rightNode;

        leftNode.left = leftNode1;
        leftNode.right =leftNode2;

        rightNode.left = rightNode1;
        rightNode.right = rightNode2;


        System.out.println(isSymmetrical(treeNode.left,treeNode.right));
    }



    private static boolean isSymmetrical(TreeNode left, TreeNode right){

        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null){
            return false;
        }

        if(left.value != right.value){
            return false;
        }

        return isSymmetrical(left.left,right.right) && isSymmetrical(left.right,right.left);
    }
}
