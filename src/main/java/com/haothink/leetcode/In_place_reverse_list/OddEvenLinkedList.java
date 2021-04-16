package com.haothink.leetcode.In_place_reverse_list;

import java.util.Objects;

/**
 * Created by wanghao on 2021-04-15
 *
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by
 * the nodes with even indices, and return the reordered list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *
 *
 * Error - Found cycle in the ListNode
 **/
public class OddEvenLinkedList {


  public static void main(String[] args) {



    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);

    one.next = two;
    two.next = three;

    OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();

    System.out.println(oddEvenLinkedList.oddEvenList(one));

  }

  public ListNode oddEvenList(ListNode head) {

    ListNode oddTail = null;

    ListNode oddHead = null;

    ListNode evenTail = null;

    ListNode evenHead = null;

    ListNode pointer = head;

    ListNode currentNode;

    int count = 0;
    while (Objects.nonNull(pointer)){

      count ++;
      currentNode = pointer;
      pointer = pointer.next;
      currentNode.next = null;

      if(count % 2 == 0){
        if(Objects.isNull(evenTail)){
          evenTail = currentNode;
          evenHead = currentNode;
        }else {
          //even
          evenTail.next = currentNode;
          evenTail = evenTail.next;
        }

      }
      if(count % 2 == 1){
        if(Objects.isNull(oddTail)){
          oddTail = currentNode;
          oddHead = currentNode;
        }else {
          //odd
          oddTail.next = currentNode;
          oddTail = oddTail.next;
        }

      }

    }

    if(Objects.nonNull(oddTail)) {
      oddTail.next = evenHead;
    }

    return oddHead;
  }

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


}
