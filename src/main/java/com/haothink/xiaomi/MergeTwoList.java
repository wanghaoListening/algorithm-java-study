package com.haothink.xiaomi;

import com.haothink.ListNode;

/**
 * Created by wanghao on 2021/10/25 mail:hiwanghao@didiglobal.com
 **/
public class MergeTwoList {

  public static void main(String[] args) {

    ListNode l1 = new ListNode(2);
    ListNode l2 = new ListNode(1);

    ListNode listNode = mergeTwoList(l1,l2);
    System.out.println(listNode);

  }

  public static ListNode mergeTwoList(ListNode l1,ListNode l2){

    // write code here
    if(l1 == null){
      return l2;
    }
    if(l2 == null){
      return l1;
    }

    ListNode newHead = null;
    ListNode headPointer = null;
    ListNode onePointer = l1;
    ListNode twoPointer = l2;
    while(onePointer != null || twoPointer != null){

      ListNode oneTemp = onePointer;
      ListNode twoTemp = twoPointer;

      Integer oneValue = oneTemp == null ? Integer.MAX_VALUE : oneTemp.val;

      Integer twoValue = twoTemp == null ? Integer.MAX_VALUE : twoTemp.val;


      if(oneValue <= twoValue){
        onePointer = onePointer.next;
        oneTemp.next = null;
        if(newHead == null){
          newHead = oneTemp;
          headPointer = newHead;
        }else{
          newHead.next = oneTemp;
          newHead = newHead.next;
        }
      }else{
        twoPointer = twoPointer.next;
        twoTemp.next = null;
        if(newHead == null){
          newHead = twoTemp;
          headPointer = newHead;
        }else{
          newHead.next = twoTemp;
          newHead = newHead.next;
        }
      }


    }

    return headPointer;
  }
}
