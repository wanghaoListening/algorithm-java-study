package com.haothink.leetcode.two_pointers;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by wanghao on 2021-03-30 mail
 *
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * 示例 1：
 * 输入：S = “ab#c”, T = “ad#c”
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 *
 * "a##c"
 * "#a#c"
 *
 * "a#c"
 * "b"
 *
 * "isfcow#"
 * "isfco#w#"
 *
 **/
public class BackspaceStringCompare {


  public static void main(String[] args) {

    BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();

    String s = "isfcow#";
    String t = "isfco#w#";

    System.out.println(backspaceStringCompare.backspaceCompare(s,t));
  }


  public boolean backspaceCompare(String s, String t) {

    char[] sch = s.toCharArray();
    char[] tch = t.toCharArray();

    int size = Math.max(sch.length,tch.length);
    int start = 0;

    List<Character> schStack = new LinkedList<>();
    List<Character> tchStack = new LinkedList<>();
    while (start < size){

      if(start < sch.length) {
        if (sch[start] != '#') {

          schStack.add(sch[start]);
        } else {
          // remove the last ele
          if (schStack.size() >= 1) {
            schStack.remove(schStack.size() - 1);
          }
        }
      }

      if(start < tch.length) {
        if (tch[start] != '#') {
          tchStack.add(tch[start]);
        } else {
          // remove the last ele
          if (tchStack.size() >= 1) {
            tchStack.remove(tchStack.size() - 1);
          }
        }
      }
      start ++;
    }

    if(schStack.size() !=tchStack.size() ){

      return false;
    }

    for(int i=0;i<schStack.size();i++){

      if(schStack.get(i) != tchStack.get(i)){

        return false;
      }
    }

    return true;

  }
}
