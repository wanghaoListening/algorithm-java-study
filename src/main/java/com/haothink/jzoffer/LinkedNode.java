package com.haothink.jzoffer;

import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年07月10日 16:58
 * description:
 */
public class LinkedNode {

    int value;

    LinkedNode next;

    public LinkedNode(int value, LinkedNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public static void printLinkedNode(LinkedNode linkedNode,String flag){

        System.out.println("==========="+flag);
        while (Objects.nonNull(linkedNode)){
            System.out.print(linkedNode.value+" ");
            linkedNode = linkedNode.next;
        }
        System.out.println();
    }

}
