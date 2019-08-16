package com.haothink.jzoffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wanghao
 * @date 2019年08月16日 19:55
 * description: 把数组排成最小的数
 *
 * 小米面试曾经遇到过此题
 *
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组 {3，32，321}，
 * 则打印出这三个数字能排成的最小数字为 321323。
 *
 *
 * 解题思路
 *
 * 先将整型数组转换成String数组；
 * 然后将String数组排序；
 * 最后将排好序的字符串数组拼接出来，这里关键就是制定排序规则。
 * 我们制定的排序规则是要求两个字符串的拼接进行比较：
 * 若ab > ba 则 a > b，
 * 若ab < ba 则 a < b，
 * 若ab = ba 则 a = b；
 *
 *
 */
public class ArrangeArraysToMinNumber {


    public static void main(String[] args) {

        int[] nums = {3,32,321};
        System.out.println(printMinNumber(nums));
    }


    private static String printMinNumber(int[] nums){
        String[] strNums = new String[nums.length];
        for(int i=0;i<strNums.length;i++){
            strNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNums,new StrComp());

        StringBuilder stringBuilder = new StringBuilder();
        for(String str: strNums){
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }


    public static class StrComp implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            String composeStr1 = o1+o2;
            String composeStr2 = o2+o1;

            return composeStr1.compareTo(composeStr2);
        }
    }
}
