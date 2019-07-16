package com.haothink.jzoffer;

import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年07月15日 19:38
 * description: 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，从头结点开始它们的值依次是5、8、3、6、2、9。这个链表的倒数第3个结点是值为6的结点。
 *
 * 解题思路：
 * 初始两个节点指针，before,after都指向链表的首节点。
 * 然后before指针先不动，先让after指针向后移动k个位置，然后两个指针一起向后移动，由于before与after相差k个位置，所以当after指向最后一个节点时，则before
 * 指针所指节点即为倒数k个节点
 *
 *
 */
public class ReciprocalKNodeInlinked {


    public static void main(String[] args) {

        LinkedNode linkedNode = new LinkedNode(5,null);
        LinkedNode linkedNode2 = new LinkedNode(8,linkedNode);
        LinkedNode linkedNode3 = new LinkedNode(3,linkedNode2);
        LinkedNode linkedNode4 = new LinkedNode(6,linkedNode3);

        System.out.println(reciprocalKNode(linkedNode4,4));


    }

    /**
     *
     * @param linkedNode
     *         链表首节点
     * @param k
     *         倒数k个节点
     * @return
     *        返回倒数第k个节点
     */
    private static LinkedNode reciprocalKNode(LinkedNode linkedNode,int k){


        if(Objects.isNull(linkedNode) || k<1){

            return null;
        }

        LinkedNode before,after;

        before = linkedNode;
        after = linkedNode;

        int kCount = 0;
        while (Objects.nonNull(after)){
            kCount ++;
            if(kCount > k){
               before = before.next;
            }
            after = after.next;
        }
        return before;
    }
}
