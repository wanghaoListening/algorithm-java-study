package com.haothink;

import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年07月10日 15:35
 * description: 删除链表中重复的结点
 *
 * 描述：
 * 题目：在一个排序的链表中，如何删除重复的结点？
 *
 * 链表1->2->3->3->4->4->5
 * 处理后为 1->2->5
 * 头结点可能与后面的结点重复，也就是说头结点也可能被删除，所以在链表头添加一个结点。
 * 我们每次都判断当前结点的值与下一个节点的值是否重复
 * 如果重复就循环寻找下一个不重复的节点，　将他们链接新新链表的尾部（其实就是删除重复的节点）
 */
public class DeleteDuplicatedLinkedNode {


    public static void main(String[] args) {

        LinkedNode linkedNode1 = new LinkedNode(5,null);
        LinkedNode linkedNode2 = new LinkedNode(5,linkedNode1);
        LinkedNode linkedNode3 = new LinkedNode(3,linkedNode2);
        LinkedNode linkedNode4 = new LinkedNode(3,linkedNode3);
        LinkedNode linkedNode5 = new LinkedNode(2,linkedNode4);
        LinkedNode linkedNode6 = new LinkedNode(2,linkedNode5);
        LinkedNode linkedNode7 = new LinkedNode(1,linkedNode6);
        LinkedNode head = new LinkedNode(0,linkedNode7);

        LinkedNode.printLinkedNode(head,"pre");
        head = deleteDuplicateNode(head);
        LinkedNode.printLinkedNode(head,"after");

    }


    private static LinkedNode deleteDuplicateNode(LinkedNode head){

        if(Objects.isNull(head.next)){
            return head;
        }

        LinkedNode currentNode = head.next;
        LinkedNode duplicatePrefixNode = head.next;
        int currentValue = 0;
        int count = 0;

        while (Objects.nonNull(currentNode)){

            if(currentValue == currentNode.value){
                count ++;
                currentNode = currentNode.next;
            }

            if(count > 1){
                //证明是重复节点，并且当前值不等于之前的值
                duplicatePrefixNode.next = currentNode;
            }else {
                count = 1;
            }

            if(Objects.nonNull(currentNode)) {
                currentValue = currentNode.value;
                duplicatePrefixNode = currentNode;
                currentNode = currentNode.next;
            }
        }

        return head;
    }


}
