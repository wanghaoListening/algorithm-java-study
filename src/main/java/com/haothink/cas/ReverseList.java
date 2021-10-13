package com.haothink.cas;


import com.haothink.ListNode;

/**
 * Created by wanghao on 2021/10/12
 **/
public class ReverseList {


  public ListNode reverseList(ListNode head){

    if(null == head){

      return null;
    }

    ListNode currPointer = head.next;
    head.next = null;
    ListNode newHead = head;

    ListNode currNode = null;

    while(currPointer != null){

      currNode = currPointer.next;
      currPointer.next = newHead;
      newHead = currPointer;
      currPointer = currNode;

    }

    return newHead;
  }

}
