package com.haothink.shoppe;

import java.util.Objects;
import java.util.Stack;

/**
 * Created by wanghao on 2021-06-27
 *
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all
 * the functions of a normal queue (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 *
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 *
 * ["MyQueue","push","push","peek","pop","empty"]
 * [[],[1],[2],[],[],[]]
 **/
public class ImplementQueueUsingStacks {


  private Stack<Integer> inStack = null;

  private Stack<Integer> outStack = null;

  public static void main(String[] args) {

  }

  /** Initialize your data structure here. */
  public ImplementQueueUsingStacks() {

    inStack = new Stack<>();
    outStack = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    inStack.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {

    if(!outStack.isEmpty()){

      return outStack.pop();
    }else {
      while (!inStack.isEmpty()){

        int ele = inStack.pop();
        outStack.push(ele);

      }
      return outStack.pop();
    }
  }

  /** Get the front element. */
  public int peek() {

    if(!outStack.isEmpty()){

      return outStack.peek();
    }else {


      while (!inStack.isEmpty()){
        int ele = inStack.pop();
        outStack.push(ele);

      }
      return outStack.peek();
    }
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {

    return inStack.isEmpty() && outStack.isEmpty();
  }


}
