package com.haothink.leetcode.slow_and_fast_pointers;

import java.util.Objects;

/**
 * Created by wanghao on 2021-04-01
 *
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 **/
public class ReorderList {

  public static void main(String[] args) {



  }


  public void reorderList(ListNode head) {

    ListNode newHead = head;

    int size = 0;
    while (Objects.nonNull(newHead)){
      size ++;
      newHead = newHead.next;
    }

    //Divide the set into 2 from middle position
    int middlePosition = size/2;
    int count = 0;
    newHead = head;

    ListNode reverseHead = null;
    ListNode nextPointer;
    while (Objects.nonNull(newHead)){

      if(count >= middlePosition){

        nextPointer = newHead.next;
        newHead.next = reverseHead;
      }

      newHead = newHead.next;
    }

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
