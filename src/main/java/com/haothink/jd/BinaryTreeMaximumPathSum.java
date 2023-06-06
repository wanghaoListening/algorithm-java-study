package com.haothink.jd;

import com.haothink.TreeNode;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the
 * sequence has an edge connecting them. A node can only appear in the sequence at most once.
 * Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 *
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 对于二叉树中任意一个节点，他能组成的最大路径和有4种可能：
 *
 * 1.当前节点值加上左子树的最大路径和
 * 2.当前节点值加上右子树的最大路径和
 * 3.当前节点值自身
 * 4.当前节点值加上左子树的最大路径和，再加上右子树的最大路径和
 * https://blog.csdn.net/fuxuemingzhu/article/details/101563683
 *
 * 经过一个节点的最大路径 = max(其左孩子为顶点的最大路径, 0) + max(右孩子为顶点的最大路径, 0) + 该节点的值。
 *
 * 公式里对左右孩子为顶点的最大路径和0取max，是因为路径可能是负值，加入左右孩子的最大路径为负数，那么就不应该使用了。
 *
 * 为什么左右孩子要为顶点的时候才行呢？一条路径不应该有分叉的，所以如果想求经过一个节点的路径的话，那么左右孩子那里不能分叉，
 * 必须是以左右孩子为出发点的一条路径：
 */
public class BinaryTreeMaximumPathSum {

    int maxVal = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);
        return maxVal;
    }

    public int dfs(TreeNode root){
        if (root == null){

            return 0;
        }

        int left = Math.max(maxPathSum(root.left),0);
        int right = Math.max(maxPathSum(root.right),0);

        maxVal = Math.max(maxVal,root.val+left+right);
        return root.val + Math.max(left,right);
    }


}
