package com.haothink.baidu;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by wanghao on 2021/10/7
 *
 * 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 输入: [10,2]
 * 输出: "102"
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 * 根据题目的要求，两个数字m和n能拼成数字mn和nm。如果mn<nm，那么我们应该打印出mn，即m应该排在n的前面，
 * 我们此时定义m小于n；反之，如果nm<mn，我们定义n小于m。如果mn=nm，我们定义m等于n。（
 * 注：符号的<，>, =是常规意义的数值大小，而文字的“大于”，“小于”，“等于”表示我们新定义的大小关系）。
 **/
public class PermutationMinNumFromArray {

  public String minNumber(int[] numbers){

    if(numbers == null || numbers.length == 0){
      return "";
    }
    int len = numbers.length;
    String []str = new String[len];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
      str[i] = String.valueOf(numbers[i]);
    }

    //这里根据自己定义的排序规则,新的排序规则,如若取最大值，~c1.compareTo(c2)
    Arrays.sort(str, new Comparator<String>() {
      public int compare(String str1, String str2) {
        String c1 = str1 + str2;
        String c2 = str2 + str1;
        return c1.compareTo(c2);
      }
    });
    for(int i = 0; i < len; i++){
      sb.append(str[i]);
    }
    return sb.toString();
  }
}
