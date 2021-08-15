package com.haothink.tencent;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by wanghao on 2021/8/14
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 * ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
 * [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
 **/
public class MinStack {

  Node last;

  class Node {
    Node(int val) {
      this.val = val;
    }
    int val;
    int currentMin;
    Node prev;
  }

  public void push(int val) {
    Node newNode = new Node(val);
    newNode.currentMin = last == null ? val : Math.min(last.currentMin, val);
    newNode.prev = last;
    last = newNode;
  }

  public void pop() {
    last = last.prev;
  }

  public int top() {
    return last.val;
  }

  public int getMin() {
    return last.currentMin;
  }
}
