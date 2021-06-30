package com.haothink.shoppe;

import java.util.Objects;

/**
 * Created by wanghao on 2021-06-30
 *
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 **/
public class MergeTwoSortedLists {

  public static void main(String[] args) {



  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    if(Objects.isNull(l1) || Objects.isNull(l2)){

      return Objects.nonNull(l1)?l1:l2;
    }
    ListNode head = new ListNode(-1);
    ListNode headPointer = head;
    ListNode onePointer = l1;
    ListNode twoPointer = l2;

    while (Objects.nonNull(onePointer) || Objects.nonNull(twoPointer)){

      if(Objects.isNull(onePointer) || Objects.isNull(twoPointer)){

        head.next = Objects.isNull(onePointer) ? twoPointer:onePointer;
        break;
      }
      if(onePointer.val <= twoPointer.val){
        head.next = onePointer;
        head = head.next;
        onePointer = onePointer.next;
      }else {
        head.next = twoPointer;
        head = head.next;
        twoPointer = twoPointer.next;
      }
    }

    return headPointer.next;
  }

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
}
