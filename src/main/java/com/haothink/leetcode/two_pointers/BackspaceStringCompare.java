package com.haothink.leetcode.two_pointers;

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
 **/
public class BackspaceStringCompare {


  public static void main(String[] args) {

    BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();

    String s = "ab#c";
    String t = "ad#c";

    System.out.println(backspaceStringCompare.backspaceCompare(s,t));
  }


  public boolean backspaceCompare(String s, String t) {



    return false;

  }
}
