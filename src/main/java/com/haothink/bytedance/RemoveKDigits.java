package com.haothink.bytedance;

import java.util.LinkedList;

/**
 * Created by wanghao on 2021/9/11
 *
 * Given string num representing a non-negative integer num, and an integer k,
 * return the smallest possible integer after removing k digits from num.
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 *
 * 维护一个递增栈，只要发现当前的数字小于栈顶元素的话，就将栈顶元素移除，比如点那个遍历到2的时候，栈里面有1和3，此时2小于栈顶元素3，
 * 那么将3移除即可。为何一定要移除栈顶元素呢，后面说不定有更大的数字呢？这是因为此时栈顶元素在高位上，就算后面的数字再大，也是在低位上，
 * 我们只有将高位上的数字尽可能的变小，才能使整个剩下的数字尽可能的小。
 *
 * "1234567890"
 * 9
 **/
public class RemoveKDigits {

  public static void main(String[] args) {

    RemoveKDigits removeKDigits = new RemoveKDigits();
    String num = "1234567890";
    int k = 9;
    System.out.println(removeKDigits.removeKdigits(num,k));
  }

  public String removeKdigits(String num, int k) {

    if(num.length() == 1 && k ==1){
      return "0";
    }
    char[] chs = num.toCharArray();
    StringBuilder stringBuilder = new StringBuilder();
    for(int i=0;i<chs.length;i++){
      while ((k > 0) &&
          (stringBuilder.length() > 0) &&
          (Character.getNumericValue(stringBuilder.charAt(stringBuilder.length()-1)) > Character.getNumericValue(chs[i]))){
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        k--;
      }
      stringBuilder.append(chs[i]);
    }
    while (k > 0){
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);
      k--;
    }
    while (stringBuilder.length()>1 && stringBuilder.charAt(0) == '0'){
      stringBuilder.deleteCharAt(0);
    }
    return stringBuilder.length() == 0?"0":stringBuilder.toString();
  }
}
