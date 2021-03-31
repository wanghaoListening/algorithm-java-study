package com.haothink.leetcode.slow_and_fast_pointers;

import java.util.Objects;

/**
 * Created by wanghao on 2021-03-31
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order, and each of their nodes contains a single digit. Add the two numbers
 * and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * 因为存储是反过来的，即数字342存成2->4->3，所以要注意进位是向后的；
 *
 * Input
 * [9,9,9,9,9,9,9]
 * [9,9,9,9]
 * Output
 * [8,9,9,9,10,9,9]
 * Expected
 * [8,9,9,9,0,0,0,1]
 *
 **/
public class AddTwoNumbers {


  public static void main(String[] args) {

    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
  }


  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    //check broader case
    if(Objects.isNull(l1) || Objects.isNull(l2)){

      return Objects.nonNull(l1)?l1:l2;
    }

    ListNode sumHeader = new ListNode();

    ListNode slideHead = sumHeader;

    int lastRemainder = 0;
    while (l1 !=null || l2 != null || lastRemainder!=0){

      int sum = (Objects.nonNull(l1)?l1.val:0) + (Objects.nonNull(l2)?l2.val:0)+lastRemainder;
      int summand = sum;
      if(sum > 9){
        summand = sum - 10;
      }
      ListNode currentNode = new ListNode();

      currentNode.val = summand;
      slideHead.next = currentNode;
      slideHead = slideHead.next;

      l1 = Objects.nonNull(l1)?l1.next:null;
      l2 = Objects.nonNull(l2)?l2.next:null;

      if(sum > 9){
        lastRemainder = 1;
      }else {
        lastRemainder = 0;
      }
    }

    return sumHeader.next;

  }


  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
