package com.haothink.leetcode.In_place_reverse_list;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.crypto.interfaces.PBEKey;

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
    ListNode four = new ListNode(4);
    /*ListNode five = new ListNode(5);*/


    one.next = two;
    two.next = three;
    three.next = four;
    /*four.next = five;
   */

    System.out.println(reverseLinkedListII.reverseBetween(one,1,3));
  }


  public ListNode reverseBetween(ListNode head, int left, int right) {

    List<ListNode> stack = new LinkedList<>();
    int count = 0;
    ListNode pointer = head;

    ListNode leftHead = head;

    ListNode currNode = null;

    ListNode preNode = null;

    while (Objects.nonNull(pointer)){

      count ++;
      currNode = pointer;
      pointer = pointer.next;
      if(count == left-1){
        preNode = currNode;
      }
      if(count >= left && count <= right){

        if(stack.size() <= 0){

          stack.add(currNode);
        }else {
          stack.get(stack.size()-1).next = currNode.next;
          currNode.next = stack.get(0);
          stack.add(0,currNode);
        }

      }

      if(count >= right){

        if(left == 1){
          return stack.get(0);
        }else {

          preNode.next = stack.get(0);
          return leftHead;
        }
      }

    }
    return leftHead;
  }

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
