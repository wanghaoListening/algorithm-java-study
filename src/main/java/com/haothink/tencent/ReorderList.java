package com.haothink.tencent;

import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by wanghao on 2021/8/18
 *
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 **/
public class ReorderList {

  public static void main(String[] args) {

    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);
    ListNode four = new ListNode(4);

    one.next = two;
    two.next = three;
    three.next = four;

    ReorderList reorderList = new ReorderList();

    reorderList.reorderList(one);
  }


  public void reorderList(ListNode head) {

    LinkedList<ListNode> listNodes = new LinkedList<>();

    ListNode newHead = head;

    while (Objects.nonNull(newHead)){
      listNodes.add(newHead);
      newHead = newHead.next;
      listNodes.getLast().next = null;
    }

    ListNode headPointer = listNodes.removeFirst();

    boolean fromHead = false;

    while (!listNodes.isEmpty()){

      if(fromHead){
        headPointer.next = listNodes.removeFirst();
        fromHead = false;
      }else {
        headPointer.next = listNodes.removeLast();
        fromHead = true;
      }
      headPointer = headPointer.next;
    }

  }



  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
