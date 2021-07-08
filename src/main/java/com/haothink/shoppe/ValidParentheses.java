package com.haothink.shoppe;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by wanghao on 2021-07-08
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Input: s = "()[]{}"
 * Output: true
 *
 * Input: s = "()"
 * Output: true
 **/
public class ValidParentheses {


  public static void main(String[] args) {

    String s = "()[]{}";

    ValidParentheses validParentheses = new ValidParentheses();
    System.out.println(validParentheses.isValid(s));
  }


  public boolean isValid(String s) {

    Map<Character,Character> parenthesesMap = new HashMap<>();
    parenthesesMap.put('(',')');
    parenthesesMap.put('{','}');
    parenthesesMap.put('[',']');

    char[] chs = s.toCharArray();

    if(chs.length % 2 == 1){

      return false;
    }

    Deque<Character> characterLinkedList = new LinkedList<>();

    for(int i=0;i<chs.length/2;i++){

      characterLinkedList.push(chs[i]);
    }

    for(int i=chs.length/2;i<chs.length;i++){

      Character ch = characterLinkedList.poll();



    }


    return true;
  }

}
