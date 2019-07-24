package com.haothink.jzoffer;

import java.util.Objects;
import java.util.Stack;

/**
 * @author wanghao
 * @date 2019年07月23日 20:21
 * description: 栈的压入、弹出序列
 *
 * 题目描述：
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，但 4,3,5,1,2 就不可能是
 * 该压栈序列的弹出序列。
 *
 * 解题思路：
 *
 * 主要思想是：创建一个辅助的堆栈，定义一个指向弹出序列第一位的指针，对于压入序列，每个数压入辅助栈中，每当压入一个
 * 数进行判断：栈顶元素与弹出序列指针所指的数进行比较，若相同则弹栈，同时指针后移一位，直到栈顶元素与指针所指元素不
 * 同，则压入下一个压入序列中的数。最终若辅助栈为空说明弹出序列为压入序列的弹出顺序。
 *
 *
 */
public class StackPopSequence {


    private static Stack<Integer> tempStack = new Stack<>();


    public static void main(String[] args) {

        int[] pushSequence = {1,2,3,4,5};
        int[] popSequence = {4,3,5,1,2};
        System.out.println(isPopSequence(pushSequence,popSequence));
    }


    private static boolean isPopSequence(int[] pushSequence,int[] popSequence){

        if(Objects.isNull(pushSequence)
                || Objects.isNull(popSequence)
                || pushSequence.length != popSequence.length){

            return false;
        }

        int popIndex = 0;
        int pushIndex = 0;

        while (popIndex < popSequence.length && pushIndex < pushSequence.length){

           if(!tempStack.isEmpty() && tempStack.peek() == popSequence[popIndex]){
               tempStack.pop();
               popIndex ++;
           }else{
               tempStack.push(pushSequence[pushIndex++]);
           }

        }

        return tempStack.isEmpty() && popIndex == popSequence.length;
    }


}
