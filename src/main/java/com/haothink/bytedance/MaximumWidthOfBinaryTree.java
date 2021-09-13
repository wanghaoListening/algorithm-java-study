package com.haothink.bytedance;

import com.haothink.TreeNode;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by wanghao on 2021/9/13
 * Given the root of a binary tree, return the maximum width of the given tree.
 *
 * The maximum width of a tree is the maximum width among all levels.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and
 * rightmost non-null nodes), where the null nodes between the end-nodes are also counted
 * into the length calculation.
 *
 * It is guaranteed that the answer will in the range of 32-bit signed integer.
 *
 * Input: root = [1,3,2,5,3,null,9]
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 *
 * 做法是层次遍历 + 完全二叉树的节点位置性质。这个性质指的是，每层都有 2 ^ (n-1)个节点。某节点的左孩子的标号是2n, 右节点的标号是2n + 1。因为这个题，中间缺少了节点的话，仍然要“认为”节点存在，所以需要使用这种标号的方法强制计算，而不是直接遍历。
 **/
public class MaximumWidthOfBinaryTree {

  public int widthOfBinaryTree(TreeNode root) {

    if(Objects.isNull(root)){
      return 0;
    }
    if(Objects.isNull(root.left) && Objects.isNull(root.right)){
      return 1;
    }
    LinkedList<NodeInfo> stack = new LinkedList<>();
    stack.addLast(new NodeInfo(root,1));
    int currNum = 1;
    int childNum = 0;
    int maxWidth = childNum;
    while (!stack.isEmpty()){
      if(currNum == 0){
        currNum = childNum;
        maxWidth = Math.max(stack.getLast().nodeNum-stack.getFirst().nodeNum+1,maxWidth);
        childNum = 0;
      }
      NodeInfo parentNodeInfo =  stack.removeFirst();
      TreeNode parentNode = parentNodeInfo.treeNode;
      currNum --;
      if(Objects.nonNull(parentNode.left)) {
        stack.addLast(new NodeInfo(parentNode.left,2*parentNodeInfo.nodeNum));
        childNum ++;
      }
      if(Objects.nonNull(parentNode.right)) {
        stack.addLast(new NodeInfo(parentNode.right,2*parentNodeInfo.nodeNum+1));
        childNum ++;
      }
    }
    return maxWidth;
  }


  public static class NodeInfo{

    public TreeNode treeNode;

    public int nodeNum;

    public NodeInfo(TreeNode treeNode, int nodeNum) {
      this.treeNode = treeNode;
      this.nodeNum = nodeNum;
    }
  }

}
