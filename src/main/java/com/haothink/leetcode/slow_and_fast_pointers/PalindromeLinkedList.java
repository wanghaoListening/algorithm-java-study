package com.haothink.leetcode.slow_and_fast_pointers;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanghao on 2021-04-02
 *
 *
 * palindrome 回文
 *
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * 使用快慢指针找中点的原理是 fast 和 slow 两个指针，每次快指针走两步，慢指针走一步，等快指针走完时，慢指针的位置就是中点。
 * 我们还需要用栈，每次慢指针走一步，都把值存入栈中，等到达中点时，链表的前半段都存入栈中了，由于栈的后进先出的性质，
 * 就可以和后半段链表按照回文对应的顺序比较了
 *
 * 14 55 41
 **/
public class PalindromeLinkedList {


  public static void main(String[] args) {

    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(2);
    ListNode four = new ListNode(1);

    one.next = two;
    two.next = three;
    three.next = four;


    PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
    System.out.println(palindromeLinkedList.isPalindrome(one));
  }


  public boolean isPalindrome(ListNode head) {

    if(Objects.isNull(head)){

      return false;
    }
    if(Objects.isNull(head.next)){

      return true;
    }

    ListNode fast = head;

    ListNode slow = head;

    List<ListNode> stack = new LinkedList<>();
    stack.add(head);
    while (Objects.nonNull(fast) && Objects.nonNull(fast.next)){

      slow = slow.next;
      fast = fast.next.next;
      stack.add(0,slow);
    }

    if (Objects.isNull(fast)) {
      stack.remove(0);
    }
    while (Objects.nonNull(slow)){

      if(slow.val != stack.remove(0).val){

        return false;
      }
      slow = slow.next;
    }

    return true;

  }


  static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
