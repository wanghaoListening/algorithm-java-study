package com.haothink.bytedance;

import com.haothink.TreeNode;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by wanghao on 2021/9/5
 *
 * Given the root of a binary tree, determine if it is a complete binary tree.
 *
 * In a complete binary tree, every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible. It can have between 1 and
 * 2h nodes inclusive at the last level h.
 *
 * Input: root = [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}),
 * and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 **/
public class CheckCompletenessOfABinaryTree {


  public boolean isCompleteTree(TreeNode root) {

    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addLast(root);
    boolean missingNode = false;
    int parentNum = 1;
    int childNum = 0;
    while (!queue.isEmpty()){

      if(parentNum == 0){
        parentNum = childNum;
        childNum = 0;
        missingNode = false;
      }
      TreeNode head = queue.removeFirst();
      if(Objects.isNull(head)){
        missingNode = true;
        continue;
      }else {
        if(missingNode){
          return false;
        }
      }

      queue.add(head.left);
      queue.add(head.right);
      parentNum --;
      childNum+=2;
    }
    return true;
  }


}
