package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年09月18日 17:53
 * description: 不用加减乘除做加法
 *
 * 题目描述：
 * 写一个函数，求两个整数之和，要求不得使用 +、-、*、/ 四则运算符号。
 *
 * 解题思路：
 *
 */
public class AddWithoutAddSubMutiDiv {


    public static void main(String[] args) {

        System.out.println(add(10,11));
    }


    private static int add(int a, int b) {
        return b == 0 ? a : add(a ^ b, (a & b) << 1);
    }


}
