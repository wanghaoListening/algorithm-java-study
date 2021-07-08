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
 * 本题是经典的Stack应用场景。遍历整个字符串，当遇到正括号时，将其插入进Stack，遇到反括号时，查看Stack的尾部是否是与之对应的正括号，如果是，
 * 将Stack尾部正括号pop出栈，反之说明不是有效括号，直接返回false。
 **/
public class ValidParentheses {


  public static void main(String[] args) {

    String s = "){";

    ValidParentheses validParentheses = new ValidParentheses();
    System.out.println(validParentheses.isValid(s));
  }


  public boolean isValid(String s) {

    Map<Character,Character> parenthesesMap = new HashMap<>();

    parenthesesMap.put(']','[');
    parenthesesMap.put('}','{');
    parenthesesMap.put(')','(');

    char[] chs = s.toCharArray();

    if(chs.length % 2 == 1){

      return false;
    }

    Deque<Character> characterLinkedList = new LinkedList<>();

    for(int i=0;i<chs.length;i++){

      if(parenthesesMap.containsKey(chs[i])){
        //反括号
        char ch = characterLinkedList.isEmpty()?' ':characterLinkedList.removeFirst();
        if(ch != parenthesesMap.get(chs[i])){

          return false;
        }
        continue;
      }
      characterLinkedList.addFirst(chs[i]);
    }
    return characterLinkedList.isEmpty();
  }

}
