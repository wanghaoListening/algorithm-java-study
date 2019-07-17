package com.haothink.jzoffer;

import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年07月16日 20:51
 * description:链表中环的入口结点
 *
 * 题目描述
 * 一个链表中包含环，请找出该链表的环的入口结点。要求不能使用额外的空间。
 *
 *
 * 解题思路：
 *
 * 1.第一种方式
 * 第一步，用两个快慢指针找环中相汇点。分别用slow, fast指向链表头部，slow每次走一步，fast每次走二步，直到fast == slow找到在环中的相汇点。
 * 第二步，找环的入口。当fast == slow时，假设slow走过x个节点，则fast走过2x个节点。设环中有n个节点，因为fast比slow多走一圈（n个节点），所
 * 以有等式2x = n + x，可以推出n = x，即slow实际上走了一个环的步数。这时，我们让fast重新指向链表头部pHead，slow的位置不变，然后slow和fast
 * 一起向前每次走一步，直到fast == slow，此时两个指针相遇的节点就是环的入口。
 *
 * 2.第二种方式
 * 不考虑其中潜在的规律，就按照一般的方法，创建一个list，把扫描过的节点都存储在list中，知道下一个节点在list中已经存在，那就说明该节点就是入口
 * 节点。这种方式下的时间复杂度为O(n2)
 */
public class EntranceNodeOfRingLinked {


    public static void main(String[] args) {

    }



    private LinkedNode entryNodeOfLoop(LinkedNode pHead){

        if(Objects.isNull(pHead) || Objects.isNull(pHead.next)){
            return null;
        }

        LinkedNode fast,slow;
        //fast 每次走两步，slow每次走1步
        fast = pHead;
        slow = pHead;

        do{
            fast = fast.next.next;
            slow = slow.next;
        }while (fast != slow);


        fast = pHead;

        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;

    }
}
