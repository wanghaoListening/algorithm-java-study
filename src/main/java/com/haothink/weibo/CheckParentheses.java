package com.haothink.weibo;

import java.util.LinkedList;

/**
 * Created by wanghao on 2021/9/24
 **/
public class CheckParentheses {


  public static void main(String[] args) {
    //234{}{234}53

    String str = "234{}{234}5{3";

    System.out.println(checkChar(str));
  }

  public static boolean checkChar(String str){

    char[] chs = str.toCharArray();

    LinkedList<Character> stack = new LinkedList<>();

    for(char ch : chs){

      if(ch == '{'){

        stack.addLast(ch);
      }else if(ch == '}'){
        if(stack.isEmpty()){
          return false;
        }
        stack.removeLast();
      }
    }
    return stack.isEmpty();
  }
}

