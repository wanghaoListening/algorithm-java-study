package com.haothink.leetcode.slow_and_fast_pointers;

import java.util.Objects;

/**
 * Created by wanghao on 2021-03-31 mail
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 **/
public class RemoveNthNodeFromEndOfList {

  public static void main(String[] args) {

  }


  public ListNode removeNthFromEnd(ListNode head, int n) {


    if(Objects.isNull(head) || Objects.isNull(head.next)){

      return null;
    }
    //create double pointer,make before pointer point n node
    ListNode before = head;
    ListNode after = head;

    for(int i=0;i<n+1;i++){

      if(Objects.isNull(before)){

        return head.next;
      }
      before = before.next;
    }
    while (Objects.nonNull(before)){

      before = before.next;
      after = after.next;
    }
    //remove one which after pointer point the next
    after.next = after.next.next;

    return head;
  }


  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
