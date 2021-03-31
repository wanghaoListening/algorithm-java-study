package com.haothink.leetcode.slow_and_fast_pointers;

import java.util.Objects;

/**
 * Created by wanghao on 2021-03-31 mail:
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again
 * by continuously following the next pointer. Internally, pos is used to denote the index of the
 * node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 **/
public class LinkedListCycle {


  public static void main(String[] args) {

  }



  public boolean hasCycle(ListNode head) {


    if(Objects.isNull(head) || Objects.isNull(head.next)){

      return false;
    }
    ListNode before = head.next.next;

    ListNode after = head;

    while (Objects.nonNull(before)){

      if(before == after){

        return true;
      }
      after = after.next;
      if(Objects.isNull(before.next)){
        return false;
      }
      before = before.next.next;
    }

    return false;
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
