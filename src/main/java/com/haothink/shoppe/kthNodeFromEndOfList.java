package com.haothink.shoppe;

import java.util.Objects;

/**
 * Created by wanghao on 2021-06-28
 *
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 **/
public class kthNodeFromEndOfList {

  public static void main(String[] args) {


  }

  public int kthToLast(ListNode head, int k) {

    ListNode before = head;
    ListNode after = head;
    int step = 0;
    while (Objects.nonNull(before)){
      step ++;
      if(step >= k){

        after = after.next;
      }
      before = before.next;
    }
    return after.val;
  }


  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
}
