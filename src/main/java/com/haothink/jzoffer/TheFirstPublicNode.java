package com.haothink.jzoffer;

import java.util.Objects;

/**
 * @author wanghao
 * @date 2019年08月30日 21:36
 * description: 两个链表的第一个公共结点
 *
 * 题目描述：
 * linked-common-node.jpg
 *
 * 解题思路：
 *
 * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
 *
 * 当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
 *
 */
public class TheFirstPublicNode {


    public static void main(String[] args) {

        LinkedNode cNode3 = new LinkedNode(32,null);

        LinkedNode cNode2 = new LinkedNode(32,cNode3);

        LinkedNode cNode1 = new LinkedNode(31,cNode2);

        LinkedNode aNode2 = new LinkedNode(12,cNode1);

        LinkedNode aNode = new LinkedNode(11,aNode2);


        LinkedNode bNode3 = new LinkedNode(23,cNode1);

        LinkedNode bNode2 = new LinkedNode(22,bNode3);

        LinkedNode bNode = new LinkedNode(21,bNode2);

        System.out.println(getCommonNode(aNode,bNode));
    }

    private static LinkedNode getCommonNode(LinkedNode aNode,LinkedNode bNode){

        LinkedNode aTemp = aNode,bTemp = bNode;

        for(;;){

            if(aTemp == bTemp){
                return aTemp;
            }

            aTemp = aTemp.next;
            bTemp = bTemp.next;

            if(Objects.isNull(aTemp)){
                aTemp = bNode;
            }
            if(Objects.isNull(bTemp)){
                bTemp = aNode;
            }
        }

    }

}
