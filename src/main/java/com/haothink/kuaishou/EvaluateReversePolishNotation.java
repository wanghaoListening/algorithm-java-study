package com.haothink.kuaishou;

import java.util.LinkedList;

/**
 * Created by wanghao on 2021/9/25
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 *
 * Note that division between two integers should truncate toward zero.
 *
 * It is guaranteed that the given RPN expression is always valid. That means the expression
 * would always evaluate to a result, and there will not be any division by zero operation.
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 **/
public class EvaluateReversePolishNotation {


  public static void main(String[] args) {

    EvaluateReversePolishNotation reversePolishNotation = new EvaluateReversePolishNotation();

    String[] tokens = {"2","1","+","3","*"};
    System.out.println(reversePolishNotation.evalRPN(tokens));

  }

  public int evalRPN(String[] tokens) {

    LinkedList<String> stack = new LinkedList<>();

    for(String token : tokens){

      if("+".equals(token)){
        int num1 = Integer.parseInt(stack.removeLast());
        int num2 = Integer.parseInt(stack.removeLast());
        stack.addLast((num1+num2)+"");
      }else if("-".equals(token)){
        int num1 = Integer.parseInt(stack.removeLast());
        int num2 = Integer.parseInt(stack.removeLast());
        stack.addLast((num2-num1)+"");
      }else if("*".equals(token)){
        int num1 = Integer.parseInt(stack.removeLast());
        int num2 = Integer.parseInt(stack.removeLast());
        stack.addLast((num1*num2)+"");
      }else if("/".equals(token)){
        int num1 = Integer.parseInt(stack.removeLast());
        int num2 = Integer.parseInt(stack.removeLast());
        stack.addLast((num2/num1)+"");
      }else {
        stack.addLast(token);
      }
    }
    return Integer.parseInt(stack.removeLast());
  }
}
