package com.haothink.leetcode.In_place_reverse_list;

import java.util.Objects;

/**
 * Created by wanghao on 2021-04-15
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 **/
public class ReverseLinkedList {


  public static void main(String[] args) {


    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);
    ListNode four = new ListNode(4);
    ListNode five = new ListNode(5);


    one.next = two;
    two.next = three;
    three.next = four;
    four.next = five;

    reverseLinkedList.reverseList(one);

  }


  public ListNode reverseList(ListNode head) {

    if(Objects.isNull(head) || Objects.isNull(head.next)){

      return head;
    }

    ListNode newHead = null;
    ListNode pointer = head;
    ListNode currNode = null;
    while (Objects.nonNull(pointer)){

      currNode = pointer;
      pointer = pointer.next;
      currNode.next = null;
      if(Objects.isNull(newHead)){
        newHead = currNode;

      }else {
        currNode.next = newHead;
        newHead = currNode;
      }

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
