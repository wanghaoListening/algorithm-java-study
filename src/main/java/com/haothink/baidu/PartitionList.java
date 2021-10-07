package com.haothink.baidu;

import com.haothink.ListNode;
import java.util.Objects;

/**
 * Created by wanghao on 2021/10/7
 *
 * Given the head of a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 *
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 *
 * 这道题要求我们划分链表，把所有小于给定值的节点都移到前面，大于该值的节点顺序不变，
 * 相当于一个局部排序的问题。那么可以想到的一种解法是首先找到第一个大于或等于给定值的节点
 *
 * 解题思路，创建2个链表一个放大于x的元素，一个放小于x的元素，然后接起来
 **/
public class PartitionList {

  public static void main(String[] args) {

    ListNode one = new ListNode(1);

    ListNode two = new ListNode(4);

    ListNode three = new ListNode(3);

    ListNode four = new ListNode(2);

    ListNode five = new ListNode(5);

    ListNode six = new ListNode(2);

    one.next = two;
    two.next = three;
    three.next = four;
    four.next = five;
    five.next = six;


    PartitionList partitionList = new PartitionList();

    ListNode result = partitionList.partition(one,3);
    System.out.println(result);

  }

  public ListNode partition(ListNode head, int x) {

    ListNode greaterXNode = new ListNode();

    ListNode greaterXHead = greaterXNode;

    ListNode lessXNode = new ListNode();

    ListNode lessXHead = lessXNode;

    while (Objects.nonNull(head)){
      if(head.val < x){
        lessXNode.next = head;
        lessXNode = lessXNode.next;
      }else {
        greaterXNode.next = head;
        greaterXNode = greaterXNode.next;
      }
      head = head.next;
    }
    greaterXNode.next = null;
    //merge
    lessXNode.next = greaterXHead.next;

    return lessXHead.next;
  }
}
