package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年09月06日 19:17
 * description: 左旋转字符串
 *
 * 题目描述：
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 *
 * 解题思路：
 *
 * 通过举个例子直白看，比如abcdefg 2，结果是cdefgab
 *
 * 第一步将ab翻转。bacdefg
 *
 * 第二步将后面的翻转。bagfedc
 *
 * 第三步全部翻转便可得到。cdefgab
 *
 *
 */
public class LeftRotationString {

    public static void main(String[] args) {

        System.out.println(leftRotateStr("abcXYZdef",3));
    }

    private static String leftRotateStr(String str,int pos){

        if(null == str || str.length() == 0){
            return "";
        }

        String str1 = str.substring(0,pos);
        String str2 = str.substring(pos);

        return (new StringBuilder(str1).reverse().append(new StringBuilder(str2).reverse()).reverse()).toString();

    }
}
