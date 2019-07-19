package com.haothink.jzoffer;

import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年07月18日 21:13
 * description: 输入两棵二叉树A 和B，判断B 是不是A 的子结构。
 *
 * 解题思路：
 * 要查找树A 中是否存在和树B 结构一样的子树，我们可以分成两步： 第一步在树A 中找到和B 的根结点的值一样的结点R，
 * 第二步再判断树A 中以R 为根结点的子树是不是包含和树B 一样的结构。
 */
public class BiTreeSubstructure {


    public static void main(String[] args) {

    }

    private static boolean isSubstructure(TreeNode aRoot,TreeNode bRoot){

        if(Objects.isNull(aRoot) || Objects.isNull(bRoot)){
            return false;
        }

        TreeNode treeNode = findTreeNodebyPreOrder(aRoot,bRoot);
        if(Objects.isNull(treeNode)){
            return false;
        }

        return compareTreeNodebyPreOrder(treeNode,bRoot);
    }


    /**
     * 递归先序遍历查找节点
     * @param aRoot
     * @param bRoot
     * @return
     *        返回存在的节点
     */
    private static TreeNode findTreeNodebyPreOrder(TreeNode aRoot,TreeNode bRoot){

        if(Objects.nonNull(aRoot)){

            if(aRoot.value == bRoot.value){
                return aRoot;
            }
            if(Objects.nonNull(aRoot.left)) {
                return findTreeNodebyPreOrder(aRoot.left, bRoot);
            }
            if(Objects.nonNull(aRoot.right)) {
                return findTreeNodebyPreOrder(aRoot.right, bRoot);
            }
        }
        return null;
    }

    /**
     * 先序递归比较两棵数是否相等
     * @param aRoot
     * @param bRoot
     * @return
     */
    private static boolean compareTreeNodebyPreOrder(TreeNode aRoot,TreeNode bRoot){

        if(Objects.nonNull(aRoot) && Objects.nonNull(bRoot)){

            if(aRoot.value != bRoot.value){
                return false;
            }else{
                return compareTreeNodebyPreOrder(aRoot.left, bRoot.left) &&
                        compareTreeNodebyPreOrder(aRoot.right, bRoot.right);
            }

        }

        return Objects.isNull(aRoot) && Objects.isNull(bRoot);

    }

}
