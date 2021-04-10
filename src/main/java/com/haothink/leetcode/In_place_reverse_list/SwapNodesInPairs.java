package com.haothink.leetcode.In_place_reverse_list;

import java.util.Objects;

/**
 * Created by wanghao on 2021-04-09
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * 翻转链表，要求不能使用额外空间的时候
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 **/
public class SwapNodesInPairs {

  public static void main(String[] args) {

    SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();

    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);


    one.next = two;
    two.next = three;



    swapNodesInPairs.swapPairs(one);

  }


  public ListNode swapPairs(ListNode head) {


    if(Objects.isNull(head) || Objects.isNull(head.next)){

      return head;
    }

    ListNode onePointer = head;
    ListNode twoPointer = head.next;
    ListNode tail = null;
    ListNode newHead = twoPointer;

    while (Objects.nonNull(onePointer) && Objects.nonNull(twoPointer)){

      //swap one and two
      ListNode swapOne = onePointer;
      ListNode swapTwo = twoPointer;

      onePointer = onePointer.next.next;
      if(Objects.nonNull(twoPointer.next)) {
        twoPointer = twoPointer.next.next;
      }else {
        twoPointer = null;
      }

      swapOne.next = null;
      swapTwo.next = swapOne;

      tail = swapOne;
      tail.next = Objects.isNull(twoPointer)?onePointer:twoPointer;

    }

    return newHead;
  }



  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
