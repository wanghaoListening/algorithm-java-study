package com.haothink.bytedance;

import com.haothink.ListNode;
import java.util.Objects;

/**
 * Created by wanghao on 2021/9/3
 *
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 *
 * 采用归并排序的思想，递归将序列分成两半，分别排序 ，然后合并
 **/
public class SortList {

  public static void main(String[] args) {

    ListNode four = new ListNode(4);
    ListNode two = new ListNode(2);
    ListNode one = new ListNode(1);
    ListNode three = new ListNode(3);

    four.next = two;
    two.next = one;
    one.next = three;

    SortList sortList = new SortList();
    ListNode resultNode = sortList.sortList(four);
    System.out.println(resultNode);

  }


  public ListNode sortList(ListNode head) {

    if (head == null || head.next == null) return head;
    ListNode slow = head, fast = head, pre = head;
    while (fast != null && fast.next != null) {
      pre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    pre.next = null;

    return merge(sortList(head), sortList(slow));
  }

  public ListNode merge(ListNode left, ListNode right) {
    if (left == null) return right;
    if (right == null) return left;
    if (left.val < right.val) {
      left.next = merge(left.next, right);
      return left;
    } else {
      right.next = merge(left, right.next);
      return right;
    }
  }

}
