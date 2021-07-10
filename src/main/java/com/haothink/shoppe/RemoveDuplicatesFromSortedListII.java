package com.haothink.shoppe;




import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * Created by wanghao on 2021-07-09
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct
 * numbers from the original list. Return the linked list sorted as well.
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 *
 * Runtime: 3 ms, faster than 9.53% of Java online submissions for Remove Duplicates from Sorted List II.
 **/
public class RemoveDuplicatesFromSortedListII {


  public static void main(String[] args) {

    ListNode oneHead = new ListNode(1);
    ListNode twoHead = new ListNode(2);
    ListNode threeHead = new ListNode(3);
    ListNode fourHead = new ListNode(3);
    ListNode fiveHead = new ListNode(4);
    ListNode sixHead = new ListNode(5);
    ListNode sevenHead = new ListNode(5);
    oneHead.next = twoHead;
    twoHead.next = threeHead;
    threeHead.next = fourHead;
    fourHead.next = fiveHead;
    fiveHead.next = sixHead;
    sixHead.next = sevenHead;

    RemoveDuplicatesFromSortedListII duplicatesFromSortedListII = new RemoveDuplicatesFromSortedListII();

    System.out.println(duplicatesFromSortedListII.deleteDuplicates(oneHead));
  }

  public ListNode deleteDuplicates(ListNode head) {

    Set<Integer> duplicateSet = new HashSet<>();
    ListNode currHeadNode = head;
    int preValue = Integer.MAX_VALUE;

    while (Objects.nonNull(currHeadNode)){

      if(currHeadNode.val == preValue){
        duplicateSet.add(currHeadNode.val);
      }
      preValue = currHeadNode.val;
      currHeadNode = currHeadNode.next;

    }

    currHeadNode = head;
    ListNode newHead = new ListNode();
    ListNode tempNode = null;
    head = newHead;
    while (Objects.nonNull(currHeadNode)){

      if(!duplicateSet.contains(currHeadNode.val)){
        newHead.next = currHeadNode;
        newHead = newHead.next;
      }
      tempNode = currHeadNode;
      currHeadNode = currHeadNode.next;
      tempNode.next = null;
    }

    return head.next;
  }


  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
