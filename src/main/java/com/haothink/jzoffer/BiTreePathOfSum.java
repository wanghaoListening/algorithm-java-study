package com.haothink.jzoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年07月30日 16:08
 * description: 二叉树中和为某一值的路径
 *
 * 题目描述：
 * 输入一棵二叉树和一个整数， 打印出二叉树中结点值的和为输入整数的所有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 解题思路：
 * 由于路径是从根结点出发到叶结点， 也就是说路径总是以根结点为起始点，因此我们首先需要遍历根结点。在树的前序、中序、后序三种遍历方式中，只有前序遍历是首先访问根结点的。
 *
 * 当用前序遍历的方式访问到某一结点时， 我们把该结点添加到路径上，并累加该结点的值。如果该结点为叶结点并且路径中结点值的和刚好等于输入的整数， 则当前的路径符合要求，我们把它打印出来。如果当前结点不是叶结点，则继续访问它的子结点。当前结点访问结束后，递归函数将自动回到它的父结点。因此我们在函数退出之前要在路径上删除当前结点并减去当前结点的值，以确保返回父结点时路径刚好是从根结点到父结点的路径。
 *
 * 不难看出保存路径的数据结构实际上是一个枝， 因为路径要与递归调用状态一致， 而递归调用的本质就是一个压栈和出栈的过程。
 *
 *
 */
public class BiTreePathOfSum {


    public static void main(String[] args) {
        //            10
        //         /      \
        //        5        12
        //       /\
        //      4  7
        TreeNode root = new TreeNode();
        root.value = 10;
        root.left = new TreeNode();
        root.left.value = 5;
        root.left.left = new TreeNode();
        root.left.left.value = 4;
        root.left.right = new TreeNode();
        root.left.right.value = 7;
        root.right = new TreeNode();
        root.right.value = 12;

        List<TreeNode> treeNodeList = new ArrayList<>();
        treeNodeList.add(root);

        findPath(treeNodeList,0,22);

    }

    /**
     *
     * @param treeNodeList
     *        存放访问过的节点
     * @param currentSum
     *        当前访问节点的值的和
     * @param pathValue
     *        路径值
     */
    private static void findPath(List<TreeNode> treeNodeList, int currentSum, int pathValue){

        if(!treeNodeList.isEmpty()) {
            TreeNode treeNode = treeNodeList.get(treeNodeList.size() - 1);
            currentSum += treeNode.value;
            if (Objects.isNull(treeNode.left) && Objects.isNull(treeNode.right) && currentSum == pathValue) {
                //证明以及是叶子节点，并且符合需求
                treeNodeList.forEach(biTreeNode -> System.out.print(biTreeNode.value+" "));
                System.out.println();

            }
            if (currentSum < pathValue && Objects.nonNull(treeNode.left)) {
                treeNodeList.add(treeNode.left);
                findPath(treeNodeList, currentSum, pathValue);

            }
            if (currentSum < pathValue && Objects.nonNull(treeNode.right)) {
                treeNodeList.add(treeNode.right);
                findPath(treeNodeList, currentSum, pathValue);
            }
            //此节点不符合要求，则删除此节点
            treeNodeList.remove(treeNodeList.size() - 1);
        }

    }
}
