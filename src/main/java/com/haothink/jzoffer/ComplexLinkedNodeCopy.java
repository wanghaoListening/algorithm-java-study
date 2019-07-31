package com.haothink.jzoffer;

import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年07月31日 16:00
 * description:  复杂链表的复制
 *
 *
 * 题目描述：
 *
 * 题目：请实现函数 ComplexListNode clone(ComplexListNode head)，复制一个复杂链表。在复杂链表中，
 * 每个结点除了有一个 next 域指向下一个结点外，还有一个 sibling 指向链表中的任意结点或者 null。
 *
 * 第一步，在每个节点的后面插入复制的节点。
 * 第二步，对复制节点的 sibling 链接进行赋值。
 * 第三步，根据奇，偶数进行拆分
 *
 */
public class ComplexLinkedNodeCopy {


    public static void main(String[] args) {
        ComplexListNode head = new ComplexListNode();
        head.value = 1;
        head.next = new ComplexListNode();
        head.next.value = 2;
        head.next.next = new ComplexListNode();
        head.next.next.value = 3;
        head.next.next.next = new ComplexListNode();
        head.next.next.next.value = 4;
        head.next.next.next.next = new ComplexListNode();
        head.next.next.next.next.value = 5;
        head.sibling = head.next.next;
        head.next.sibling = head.next.next.next.next.next;
        head.next.next.next.sibling = head.next;
        printLinkedNode(head,"复制前");
        ComplexListNode newHead = clone(head);
        printLinkedNode(head,"复制后");
        printLinkedNode(newHead,"复制节点");

    }


    private static ComplexListNode clone(ComplexListNode complexListNode){

        if(Objects.isNull(complexListNode)){


            return null;
        }

        //第一步，在每个节点的后面插入复制的节点。

        ComplexListNode tempNode = complexListNode;
        do{

            ComplexListNode newListNode = new ComplexListNode();
            newListNode.value = tempNode.value;
            newListNode.next = tempNode.next;
            tempNode.next = newListNode;
            tempNode = newListNode.next;

        }while (Objects.nonNull(tempNode));

        //第二步，对复制节点的 sibling 链接进行赋值。
        ComplexListNode preNode = complexListNode;

        do{
            ComplexListNode afterNode = preNode.next;
            if(Objects.nonNull(preNode.sibling)) {
                afterNode.sibling = preNode.sibling.next;
            }
            preNode = afterNode.next;

        }while (Objects.nonNull(preNode));

        //第二步，对复制节点的 sibling 链接进行赋值。
        ComplexListNode copyListNode = null,tempCopyListNode = null;
        ComplexListNode previousNode = complexListNode;
        int count = 1;
        while (Objects.nonNull(complexListNode)){

            if(count % 2 == 0){

                if(Objects.isNull(tempCopyListNode)){
                    copyListNode = complexListNode;
                    tempCopyListNode = complexListNode;
                }else{
                    tempCopyListNode.next = complexListNode;
                    tempCopyListNode = tempCopyListNode.next;
                }
                complexListNode = complexListNode.next;
                previousNode.next = complexListNode;
                previousNode = previousNode.next;

            }else {
                complexListNode = complexListNode.next;
            }
            count ++;
        }

        return copyListNode;
    }

    public static void printLinkedNode(ComplexListNode linkedNode,String flag){

        System.out.println("==========="+flag);
        while (Objects.nonNull(linkedNode)){
            System.out.print(linkedNode.value+" ");
            linkedNode = linkedNode.next;
        }
        System.out.println();
    }


    private static class ComplexListNode{

        int value;
        //指向下一个节点
        ComplexListNode next;
        //指向任一个节点
        ComplexListNode sibling;

        @Override
        public String toString() {
            return "ComplexListNode{" +
                    "value=" + value +
                    ", next=" + next +
                    ", sibling=" + sibling +
                    '}';
        }
    }
}
