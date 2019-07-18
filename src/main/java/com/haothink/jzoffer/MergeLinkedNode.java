package com.haothink.jzoffer;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年07月18日 20:04
 * description: 合并两个排序的链表
 *
 * 描述：
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表依然满足排序规则
 *
 * 方法一：
 * 新建一个链表newHead，同时遍历head1，head2将小的元素节点依次插入newHead
 */
public class MergeLinkedNode {


    public static void main(String[] args) {

        LinkedNode linkedNode1 = new LinkedNode(9,null);
        LinkedNode linkedNode2 = new LinkedNode(8,linkedNode1);
        LinkedNode linkedNode3 = new LinkedNode(6,linkedNode2);
        LinkedNode linkedNode4 = new LinkedNode(5,linkedNode3);
        LinkedNode linkedNode5 = new LinkedNode(5,linkedNode4);
        LinkedNode linkedNode6 = new LinkedNode(3,linkedNode5);
        LinkedNode head1 = new LinkedNode(1,linkedNode6);


        LinkedNode linkedNode7 = new LinkedNode(12,null);
        LinkedNode linkedNode8 = new LinkedNode(7,linkedNode7);
        LinkedNode linkedNode9 = new LinkedNode(6,linkedNode8);
        LinkedNode linkedNode10 = new LinkedNode(6,linkedNode9);
        LinkedNode linkedNode11 = new LinkedNode(4,linkedNode10);
        LinkedNode head2 = new LinkedNode(3,linkedNode11);

        //LinkedNode newLinkedNode = merge(head1,head2);

        LinkedNode headNode = new LinkedNode();
        merge2(headNode,head1,head2);
        LinkedNode.printLinkedNode(headNode,"new");
    }


    private static LinkedNode merge(LinkedNode head1,LinkedNode head2){

        LinkedNode newHead = new LinkedNode();
        LinkedNode currentNode = newHead;

        while (Objects.nonNull(head1) && Objects.nonNull(head2)){

            if(head1.value < head2.value){
                //小于
                currentNode.next = head1;
                currentNode = currentNode.next;
                head1 = head1.next;
            }else if(head1.value == head2.value){
                //等于
                currentNode.next = head1;
                currentNode = currentNode.next;
                head1 = head1.next;
                currentNode.next = head2;
                currentNode = currentNode.next;
                head2 = head2.next;
            }else{
                //大于
                currentNode.next = head2;
                currentNode = currentNode.next;
                head2 = head2.next;
            }
        }

        if(Objects.nonNull(head1)){
            currentNode.next = head1;
        }

        if(Objects.nonNull(head2)){
            currentNode.next = head2;
        }

        return newHead;
    }

    //递归合并head1,head2
    private static void merge2(LinkedNode currentNode,LinkedNode head1,LinkedNode head2){

        if(Objects.isNull(head1) && Objects.isNull(head2)){
            return;
        }
        if(Objects.nonNull(head1) && Objects.isNull(head2)){
            currentNode.next = head1;
            return;

        }
        if(Objects.isNull(head1)){
            currentNode.next = head2;
            return;
        }

        if(head1.value < head2.value){
            //小于
            currentNode.next = head1;
            currentNode = currentNode.next;
            head1 = head1.next;
        }else if(head1.value == head2.value){
            //等于
            currentNode.next = head1;
            currentNode = currentNode.next;
            head1 = head1.next;
            currentNode.next = head2;
            currentNode = currentNode.next;
            head2 = head2.next;
        }else{
            //大于
            currentNode.next = head2;
            currentNode = currentNode.next;
            head2 = head2.next;
        }
        merge2(currentNode,head1,head2);

    }

}
