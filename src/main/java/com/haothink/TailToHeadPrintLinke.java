package com.haothink;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author wanghao
 * @date 2019年06月13日 23:02
 * description:
 *
 * 推荐方法
 * 使用头插法可以得到一个逆序的链表。
 *
 * 头结点和第一个节点的区别：
 *
 * 头结点是在头插法中使用的一个额外节点，这个节点不存储值；
 * 第一个节点就是链表的第一个真正存储值的节点。
 * [1]->[2]->[3]
 * []->[1]
 * []->[2]->[1]
 * []->[3]->[2]->[1]
 */
public class TailToHeadPrintLinke {


    private static List<Integer> values = new ArrayList<>();
    public static void main(String[] args) {

        ListNode listNode3 = new ListNode(3,null);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode = new ListNode(1,listNode2);

        ListNode linkNode = printListFromTailToHeadeByHInsert(listNode);

        linkNode = linkNode.getNext();
        while (Objects.nonNull(linkNode)){

            System.out.println(linkNode.getValue());

            linkNode = linkNode.getNext();

        }
        //System.out.println(printListFromTailToHeadeByRcursion(listNode));
    }


    /**
     * 递归方法打印
     * @param listNode
     * @return
     *
     * 要逆序打印链表 1->2->3（3,2,1)，可以先逆序打印链表 2->3(3,2)，最后再打印第一个节点 1。而链表 2->3 可以看成一个新的链表，
     * 要逆序打印该链表可以继续使用求解函数，也就是在求解函数中调用自己
     */
    private static List<Integer> printListFromTailToHeadeByRcursion(ListNode listNode){

        if(Objects.nonNull(listNode.next)){
            printListFromTailToHeadeByRcursion(listNode.next);

        }
        values.add(listNode.value);
        return values;
    }


    /***
     * 采用头插法
     * @param listNode
     * @return
     */
    private static ListNode printListFromTailToHeadeByHInsert(ListNode listNode){

        //初始一个空的节点
        ListNode listNodeEmpty = new ListNode();
        while (Objects.nonNull(listNode)){

            ListNode tempNode = new ListNode(listNode.getValue(),null);
            if(Objects.isNull(listNodeEmpty.getNext())){
                //直接插入
                listNodeEmpty.setNext(tempNode);
            }else{
                //说明已经有节点插入
                tempNode.setNext(listNodeEmpty.getNext());
                listNodeEmpty.setNext(tempNode);
            }
            listNode = listNode.getNext();
        }

        return listNodeEmpty;
    }


    public ArrayList<Integer> printListFromTailToHeadByStack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.value);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }




    private static class ListNode{

        private Integer value;

        private ListNode next;

        public ListNode() {
        }

        public ListNode(Integer value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

}
