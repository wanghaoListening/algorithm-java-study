package com.haothink.leetcode.In_place_reverse_list;

import java.util.Objects;

/**
 * Created by wanghao on 2021-04-13
 *
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 **/
public class ReverseLinkedListII {


  public static void main(String[] args) {


    ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();

    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);
    /*ListNode four = new ListNode(4);
    ListNode five = new ListNode(5);*/


    one.next = two;

    two.next = three;
   /* three.next = four;
    four.next = five;
   */

    System.out.println(reverseLinkedListII.reverseBetween(one,1,3));
  }


  public ListNode reverseBetween(ListNode head, int left, int right) {

    int count = 0;
    ListNode pointer = head;
    ListNode leftHead = null;
    ListNode currNode = null;
    ListNode preNode = null;

    while (Objects.nonNull(pointer)){

      count++;
      if(count == left-1){
        leftHead = pointer;
      }
      if(count == left){
        preNode = pointer;
      }

      if(count >= left+1 && count <=right){

        currNode = pointer;
        pointer = pointer.next;
        if(Objects.nonNull(leftHead)) {
          preNode.next = currNode.next;
          currNode.next = leftHead.next;
          leftHead.next = currNode;
        }else {
          //prove left is vary left index ,so preNode.next = null
          if(count == 2){
            preNode.next = null;
          }
          currNode.next = preNode;
          preNode = currNode;
          head = currNode;
        }
        continue;
      }
      if(count > right){

        break;
      }
      pointer = pointer.next;
    }
    return head;
  }

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
