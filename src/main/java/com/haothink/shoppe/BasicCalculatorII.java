package com.haothink.shoppe;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wanghao on 2021-07-18
 *Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical
 * expressions, such as eval().
 *
 * Input: s = "3+2*2"
 * Output: 7
 *
 * Input: s = " 3/2 "
 * Output: 1
 *
 **/
public class BasicCalculatorII {


  public static void main(String[] args) {

    String s = "1*2-3/4+5*6-7*8+9/10";
    BasicCalculatorII basicCalculatorII = new BasicCalculatorII();

    System.out.println(basicCalculatorII.calculate(s));
  }



  public int calculate(String s) {
    s = s.trim();
    String[] numStrs = s.split("[\\+\\-\\*/]");

    LinkedList<Character> operateCharStack = new LinkedList<>();

    char[] chs = s.toCharArray();

    for(char ch : chs){

      if(ch == '+'|| ch == '-' || ch == '/' || ch == '*'){

        operateCharStack.addLast(ch);
      }
    }

    LinkedList<Integer> stack = new LinkedList<>();

    stack.addLast(Integer.parseInt(numStrs[0]));
    int i=1;
    while (i<numStrs.length){
      char charOperate = operateCharStack.removeFirst();
      if(charOperate == '+'){
        stack.addLast(Integer.parseInt(numStrs[i].trim()));
      }else if(charOperate == '-'){
        stack.addLast(Integer.parseInt("-"+numStrs[i].trim()));
      }else if(charOperate == '/'){
        stack.addLast(stack.removeLast()/Integer.parseInt(numStrs[i].trim()));
      }else if(charOperate == '*'){
        stack.addLast(stack.removeLast()*Integer.parseInt(numStrs[i].trim()));
      }
      i++;
    }
    int sum = 0;
    for(Integer num : stack){

      sum+=num;
    }
    return sum;
  }
}
