package com.haothink.leetcode.slow_and_fast_pointers;

import java.util.Objects;

/**
 * Created by wanghao on 2021-04-02
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 *
 **/
public class MiddleOfTheLinkedList {


  public static void main(String[] args) {

    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);
    ListNode four = new ListNode(4);


    one.next = two;
    two.next = three;
    three.next = four;


    MiddleOfTheLinkedList middleOfTheLinkedList = new MiddleOfTheLinkedList();
    System.out.println(middleOfTheLinkedList.middleNode(one));

  }

  public ListNode middleNode(ListNode head) {

    if(Objects.isNull(head.next)){

      return head;
    }

    ListNode fast = head;
    ListNode slow = head;

    while (Objects.nonNull(fast) && Objects.nonNull(fast.next)){

      fast = fast.next.next;
      slow = slow.next;

    }

    return slow;
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
