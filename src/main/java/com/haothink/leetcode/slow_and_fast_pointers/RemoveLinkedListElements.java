package com.haothink.leetcode.slow_and_fast_pointers;

import java.util.Objects;

/**
 * Created by wanghao on 2021-04-02
 *
 * Given the head of a linked list and an integer val, remove all the nodes of the linked
 * list that has Node.val == val, and return the new head.
 **/
public class RemoveLinkedListElements {


  public static void main(String[] args) {

  }


  public ListNode removeElements(ListNode head, int val) {

    ListNode newHeader = new ListNode(-100);
    ListNode sildeHeader = newHeader;
    ListNode pointer = head;

    while (Objects.nonNull(pointer)){

        if(pointer.val != val){

          sildeHeader.next = pointer;
          sildeHeader = sildeHeader.next;
        }

        pointer = pointer.next;
    }

    sildeHeader.next = null;
    return newHeader.next;

  }

  static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
