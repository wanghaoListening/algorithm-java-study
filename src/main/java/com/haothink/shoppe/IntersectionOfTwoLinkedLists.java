package com.haothink.shoppe;

import java.util.Objects;

/**
 * Created by wanghao on 2021-06-26
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 *
 * For example, the following two linked lists begin to intersect at node c1:
 *
 * 找出两个链表的最早公共元素。
 * 将链表看为环进行解答
 * 1.长度相同的话， a 和 b 一定是同时到达相遇点，然后返回。
 * 2.长度不同的话，较短的链表先到达结尾，然后指针转向较长的链表。此刻，较长的链表继续向末尾走，多走的距离刚好就是最开始介绍的解法，
 * 链表的长度差，走完之后指针转向较短的链表。然后继续走的话，相遇的位置就刚好是相遇点了。
 **/
public class IntersectionOfTwoLinkedLists {


  public static void main(String[] args) {


  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {


    if(Objects.isNull(headA) || Objects.isNull(headB)){

      return null;
    }

    while (true){

      if(headA == headB){

        return headA;
      }


    }

  }

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }

}
