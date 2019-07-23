package com.haothink.jzoffer;

import java.util.Stack;

/**
 * @author wanghao
 * @date 2019年07月22日 18:49
 * description: 包含min函数的栈
 *
 * 描述：
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * 思路：
 *
 * 以空间换时间,使用一个辅助栈minStack存放每一次入栈操作的最小元素，min()函数直接从辅助栈minStack的栈顶即可取到最小元素，在O(1)时间内完成。
 * 当最小元素从原数据栈stack内被弹出时，同时弹出辅助栈minStack内的栈顶元素，则mins辅助栈的新的栈顶元素就是下一个最小值。
 */
public class ContainMinFunOfStack {


    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> stack = new Stack<>();


    public void push(Integer value){

        stack.push(value);
        minStack.push(minStack.isEmpty()?value:Math.min(minStack.peek(),value));
    }

    public Integer pop(){

        minStack.pop();
        return stack.pop();
    }

    public Integer min(){

        return minStack.peek();
    }


    public static void main(String[] args) {

        ContainMinFunOfStack containMinFunOfStack = new ContainMinFunOfStack();

        containMinFunOfStack.push(10);
        containMinFunOfStack.push(4);
        containMinFunOfStack.push(9);
        containMinFunOfStack.push(2);

        System.out.println(containMinFunOfStack.min());
        System.out.println(containMinFunOfStack.pop());
        System.out.println(containMinFunOfStack.min());
    }
}
