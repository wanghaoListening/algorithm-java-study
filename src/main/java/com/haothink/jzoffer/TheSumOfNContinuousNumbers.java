package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年09月17日 18:07
 * description: 求1到n的序列的和
 *
 * 题目描述：
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 解题思路:
 * 可以利用短路与进行代替，A&&B 当A条件满足后才会执行B条件
 */
public class TheSumOfNContinuousNumbers {


    public static void main(String[] args) {

        System.out.println(sumSolution(10));
    }

    private static int sumSolution(int n){

        int sum = n;
        boolean b = (n > 0) && ((sum +=sumSolution(sum-1)) >0);
        return sum;
    }
}
