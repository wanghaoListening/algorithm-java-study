package com.haothink.leetcode.In_place_reverse_list;


import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanghao on 2021-04-10
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number
 * of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * Follow up:
 *
 * Could you solve the problem in O(1) extra memory space?
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 * 如果节点数不是k的倍数，则忽略节点，
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 **/
public class ReverseNodesInkGroup {


  public static void main(String[] args) {


    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);
    ListNode four = new ListNode(4);
    ListNode five = new ListNode(5);


    one.next = two;
    two.next = three;
    three.next = four;
    four.next = five;

    int k = 3;
    ReverseNodesInkGroup reverseNodesInkGroup = new ReverseNodesInkGroup();
    System.out.println(reverseNodesInkGroup.reverseKGroup(one,k));
  }

  public ListNode reverseKGroup(ListNode head, int k) {


    if(Objects.isNull(head) || Objects.isNull(head.next)){

      return head;
    }
    //pre calc linked length
    int count = 0;
    ListNode pointer = head;
    while (Objects.nonNull(pointer)){
      count ++;
      pointer = pointer.next;
    }

    int group = count/k;
    int standard = group;
    List<ListNode> stack = new LinkedList<>();
    ListNode currNode;
    ListNode connectNode = head;
    ListNode newHead = null;
    pointer = head;
    while(Objects.nonNull(pointer)){
      currNode = pointer;
      pointer = pointer.next;

      if(group == 0){
        connectNode.next = currNode;
        return newHead;
      }
      if(stack.size() > 0) {
        currNode.next = stack.get(stack.size()-1);
      }else {
        currNode.next = null;
      }
      stack.add(currNode);
      if(stack.size() >= k){
        if(standard == group){
          newHead = stack.get(stack.size()-1);
        }
        //connect two group
        if(group < standard) {
          connectNode.next = stack.get(stack.size() - 1);
        }
        connectNode = stack.get(0);
        stack.clear();
        group --;
      }
    }
    return newHead;
  }

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
