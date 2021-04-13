package com.haothink.leetcode.In_place_reverse_list;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanghao on 2021-04-13
 *
 * Given the head of a linked list, rotate the list to the right by k places.
 **/
public class RotateList {

  public static void main(String[] args) {

    RotateList rotateList = new RotateList();

    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);
    ListNode four = new ListNode(4);
    ListNode five = new ListNode(5);


    one.next = two;
    two.next = three;
    three.next = four;
    four.next = five;

    System.out.println(rotateList.rotateRight(one,2));

  }




  public ListNode rotateRight(ListNode head, int k) {

    if(Objects.isNull(head) || Objects.isNull(head.next)){

      return head;
    }

    List<ListNode> stack = new LinkedList<>();

    ListNode pointer = head;

    while (Objects.nonNull(pointer)){

      stack.add(pointer);
      pointer = pointer.next;
    }

    if(k > stack.size()){

      k = k % stack.size();
    }

    for(int i=0;i<k;i++){

      ListNode tailNode = stack.remove(stack.size()-1);

      ListNode secondTailNode = stack.get(stack.size()-1);
      //prevent list circle
      secondTailNode.next = null;

      tailNode.next = stack.get(0);

      stack.add(0,tailNode);

    }

    return stack.get(0);
  }

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
