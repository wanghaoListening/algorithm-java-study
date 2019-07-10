package com.haothink;

import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年07月09日 21:01
 * description: 在O(1)时间删除链表节点
 *
 * 给定单向链表的头指针head和一个节点指针p，定义一个函数在O(1)时间删除该节点p。
 *
 * 在链表中删除一个结点，最常规的做法是从链表的头结点开始，顺序查找要删除的结点，找到之后再删除。由于需要顺序查找，时间复杂度自然就是O(n) 了。
 *
 * 我们之所以需要从头结点开始查找要删除的结点，是因为我们需要得到要删除的结点的前面一个结点。我们试着换一种思路。我们可以从给定的结点得到它的下一个结点。
 * 这个时候我们实际删除的是它的下一个结点，由于我们已经得到实际删除的结点的前面一个结点，因此完全是可以实现的。当然，在删除之前，我们需要需要把给定的结
 * 点的下一个结点的数据拷贝到给定的结点中。此时，时间复杂度为O(1)。
 *
 * 上面的思路还有一个问题：如果删除的结点位于链表的尾部，没有下一个结点，怎么办？我们仍然从链表的头结点开始，顺便遍历得到给定结点的前序结点，并完成删除
 * 操作。这个时候时间复杂度是O(n)。那题目要求我们需要在O(1)时间完成删除操作，我们的算法是不是不符合要求？实际上，假设链表总共有n个结点，我们的算法在n-1总
 * 情况下时间复杂度是O(1)，只有当给定的结点处于链表末尾的时候，时间复杂度为O(n)。那么平均时间复杂度[(n-1)*O(1)+O(n)]/n，仍然为O(1)。
 *
 * [6]->[3]->[8]->[5]
 *
 * [6]->[3]->[5]
 */
public class DeleteLinkedNode {


    public static void main(String[] args) {

        LinkedNode linkedNode = new LinkedNode(5,null);
        LinkedNode linkedNode2 = new LinkedNode(8,linkedNode);
        LinkedNode linkedNode3 = new LinkedNode(3,linkedNode2);
        LinkedNode linkedNode4 = new LinkedNode(6,linkedNode3);
        LinkedNode head = linkedNode4;
        LinkedNode p = linkedNode2;
        LinkedNode.printLinkedNode(head,"pre");

        head = deleteNode(head,p);
        LinkedNode.printLinkedNode(head,"after");


    }


    /**
     *
     * @param head
     *        头指针
     * @param p
     *        节点指针
     * @return
     *        删除后的链表
     */
    private static LinkedNode deleteNode(LinkedNode head,LinkedNode p){

        if(Objects.isNull(head) || Objects.isNull(p)){
            return null;
        }

        if(Objects.nonNull(p.next)){
            //证明不是尾节点
            p.value = p.next.value;
            p.next = p.next.next;
            return head;
        }

        LinkedNode temp = head;
        //如果是尾节点只能从头开始遍历
        while (Objects.nonNull(temp.next) && (temp.next != p)){

            temp = temp.next;
        }

        temp.next = null;
        p = temp;
        return head;
    }



}
