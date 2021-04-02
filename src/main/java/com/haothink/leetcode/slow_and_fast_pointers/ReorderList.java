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
 *
 * 把一个链表的前半部分正序，后半部分逆序，然后一个一个的连接起来。
 **/
public class ReorderList {

  public static void main(String[] args) {

    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);
    ListNode four = new ListNode(4);
    ListNode five = new ListNode(5);


    one.next = two;
    two.next = three;
    three.next = four;
    four.next = five;


    ReorderList reorderList = new ReorderList();

    reorderList.reorderList(one);

    System.out.println(one);

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

    ListNode reverseHead = new ListNode(-100);
    ListNode nextPointer;
    while (Objects.nonNull(newHead)){

      if(count >= middlePosition){

        nextPointer = newHead.next;
        newHead.next = null;
        if(Objects.isNull(reverseHead.next)){

          reverseHead.next = newHead;
        }else {
          //insert head pos
          newHead.next = reverseHead.next;
          reverseHead.next = newHead;
        }
        newHead = nextPointer;
      }else {
        newHead = newHead.next;
      }
      count ++;
    }

    //merge two list
    reverseHead = reverseHead.next;

    ListNode headPointer = head;
    ListNode before;
    ListNode after;
    while (Objects.nonNull(headPointer) && Objects.nonNull(reverseHead) && reverseHead != headPointer){
      //
      before = headPointer.next;
      after = reverseHead.next;

      reverseHead.next = headPointer.next;
      headPointer.next = reverseHead;

      headPointer = before;
      reverseHead = after;

    }
    //prevent circle reference
    if(Objects.nonNull(headPointer)) {
      headPointer.next = null;
    }

    if(Objects.nonNull(reverseHead)) {
      reverseHead.next = null;
    }
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
