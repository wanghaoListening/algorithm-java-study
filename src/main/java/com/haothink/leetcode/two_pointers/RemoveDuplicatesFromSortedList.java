package com.haothink.leetcode.two_pointers;


/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only
 * once. Return the linked list sorted as well.
 */
public class RemoveDuplicatesFromSortedList {


  public static void main(String[] args) {


    RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();


  }


  public ListNode deleteDuplicates(ListNode head) {

    if(head == null){

      return null;
    }

    ListNode before = head;

    ListNode after = before.next;

    while (after != null){

      if(before.val == after.val){
        //remove it
        before.next = after.next;
        after = before.next;
      }else {
        before = after;
        after = after.next;
      }

    }

    return head;
  }


  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }


}
