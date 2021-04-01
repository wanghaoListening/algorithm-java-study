package com.haothink.leetcode.slow_and_fast_pointers;

import java.util.Objects;

/**
 * Created by wanghao on 2021-03-31
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again
 * by continuously following the next pointer. Internally, pos is used to denote the index of the
 * node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * 快指针每次走2，慢指针每次走,相遇的点的距离 与 环一圈的距离相等
 * 首先，设从链表头到环开始节点距离为x；环的长度为y；从环开始处到相遇处距离为k；x即为我们要求的距离。
 * 第一步，设快指针与慢指针在5节点处相遇，则快指针走过x+y+k；慢指针走过x+k。因为我们已知快指针走过的长度为慢指针的两倍，则可得公式1 2(x + k) = x + y + k；
 * 第二步，整理公式，得到公式2 x + k = y；
 * 第三步，得到公式3 x = y - k即为我们要求的距离
 *
 **/
public class LinkedListCycleII {

  public static void main(String[] args) {


  }


  public ListNode detectCycle(ListNode head) {

    if(Objects.isNull(head) || Objects.isNull(head.next)){
      //no circle
      return null;
    }
    ListNode before = head;

    ListNode after = head;

    boolean existCycle = false;
    while (Objects.nonNull(before) && Objects.nonNull(before.next)){
      after = after.next;
      before = before.next.next;
      if(before == after){
        //break circle
        existCycle = true;
        break;
      }
    }
    if(!existCycle){
      return null;
    }

    after = head;
    while (after != before){

     after = after.next;
     before = before.next;
    }

    return after;
  }


  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
