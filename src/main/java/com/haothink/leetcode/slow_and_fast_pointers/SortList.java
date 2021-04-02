package com.haothink.leetcode.slow_and_fast_pointers;




/**
 * Created by wanghao on 2021-04-02
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 *
 * 解析：看到时间空间复杂度的要求，第一反应想到快排的思路， 但是由于链表只能通过next指针单向索引，所以pass。
 * 看了网上的参考思路使用归并排序，由于链表在归并操作时并不需要像数组的归并操作那样分配一个临时数组空间，
 * 所以这样就是常数空间复杂度了，所以不考虑递归的栈开销，算法空间复杂度就是O(1)。思路：利用快慢指针将链表
 * 分为两部分，然后对两部分分别进行排序，然后合并两个有序序列，
 **/
public class SortList {


  public static void main(String[] args) {

  }


  public ListNode sortList(ListNode head) {


    ListNode before = head;

    ListNode after = head.next;


    return null;
  }


  public void sort(ListNode before,ListNode after){



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
