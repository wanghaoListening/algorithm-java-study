package com.haothink.jzoffer;
import java.util.*;


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
        root1.left.right.left.left = new TreeNode();
        root1.left.right.left.left.value = 4;
        root1.left.right.left.right = new TreeNode();
        root1.left.right.left.right.value = 7;
        TreeNode root2 = new TreeNode();
        root2.value = 8;
        root2.left = new TreeNode();
        root2.left.value = 9;
        root2.right = new TreeNode();
        root2.right.value = 2;
        System.out.println(isSubstructure(root1, root2));
        System.out.println(isSubstructure(root2, root1));
        System.out.println(isSubstructure(root1, root1.left));
    }

    private static boolean isSubstructure(TreeNode aRoot,TreeNode bRoot){

        if(Objects.isNull(aRoot) || Objects.isNull(bRoot)){
            return false;
        }

        List<TreeNode> treeNodeList = findTreeNodebyLevelOrder(aRoot,bRoot);
        if(Objects.isNull(treeNodeList) || treeNodeList.isEmpty()){
            return false;
        }
        boolean isExist = false;

        for(TreeNode treeNode:treeNodeList){
            if(compareTreeNodebyPreOrder(treeNode,bRoot)){
                isExist = true;
                break;
            }
        }

        return isExist;
    }


    /**
     *
     * 按层级遍历查找节点
     * @param aRoot
     * @param bRoot
     * @return
     *        由于A树种可能存在不止一个节点与B数根节点值相等
     *        返回与bRoot值相等的A树的节点列表
     */
    private static List<TreeNode> findTreeNodebyLevelOrder(TreeNode aRoot,TreeNode bRoot){
        List<TreeNode> treeNodeList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(aRoot);
        TreeNode firstNode = queue.poll();
        while (Objects.nonNull(firstNode)){

            if(firstNode.value == bRoot.value){
                treeNodeList.add(firstNode);
            }
            if(Objects.nonNull(firstNode.left)) {
                queue.offer(firstNode.left);
            }
            if(Objects.nonNull(firstNode.right)) {
                queue.offer(firstNode.right);
            }
            firstNode = queue.poll();
        }

        return treeNodeList;
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
        //证明B树的节点已经全部比较完成
        return Objects.isNull(bRoot);

    }

}
