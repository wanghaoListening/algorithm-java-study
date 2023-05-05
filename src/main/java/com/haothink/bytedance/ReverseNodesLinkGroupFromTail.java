package com.haothink.bytedance;

import com.haothink.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 *  给定一个单链表的头节点 head,实现一个调整单链表的函数，使得每K个节点之间为一组进行逆序，并且从链表的尾部开始组起，头部剩余节点数量不够一组的不需要逆序。
 *  链表:1->2->3->4->5->6->7->8->null, K = 3。那么 6->7->8，3->4->5，1->2各位一组。调整后：1->2->5->4->3->8->7->6->null。其中 1，2不调整，因为不够一组。
 *
 *  解题思路：
 *  先把单链表进行一次逆序，逆序之后就能转化为从头部开始组起了，然后按照k group 处理，处理完之后，把结果再次逆序即搞定。两次逆序相当于没逆序。
 */
public class ReverseNodesLinkGroupFromTail {


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

        int k = 2;

        ReverseNodesLinkGroupFromTail reverseNodesLinkGroupFromTail = new ReverseNodesLinkGroupFromTail();
        ListNode result = reverseNodesLinkGroupFromTail.reverseLinkedNode(one);
        System.out.println(result);
        reverseNodesLinkGroupFromTail.reverseKGroupFromTail(one,k);
    }


    public ListNode reverseKGroupFromTail(ListNode head, int k) {

        //先将链表进行逆序,头插法，翻转链表
        head = reverseLinkedNode(head);

        //遍历k个节点放到栈当中，
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode preHead = new ListNode();
        ListNode preHeadPointer = preHead;
        ListNode tempPointer;
        while (head != null){
            tempPointer = head.next;
            if (stack.size() >= k){
                while (!stack.isEmpty()){
                    preHead.next = stack.removeLast();
                    preHead = preHead.next;
                }
            }else {
                stack.addLast(head);
            }
            head = tempPointer;
        }
        //再次将链表进行逆序
        return reverseLinkedNode(preHeadPointer.next);
    }

    public ListNode reverseLinkedNode(ListNode head){

        ListNode preHead = new ListNode(-1);
        ListNode tempPointer;
        while (head != null){
            tempPointer = head.next;
            if (preHead.next != null){
                //头插入法
                head.next = preHead.next;
            }else {
                head.next = null;
            }
            preHead.next = head;
            head = tempPointer;
        }
        return preHead.next;
    }
}
