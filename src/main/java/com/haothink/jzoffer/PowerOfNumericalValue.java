package com.haothink.jzoffer;

/**
 * @author wanghao
 * @date 2019年07月06日 17:57
 * description: 数值的整数次方
 *
 * 题目描述
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。
 *
 * 解题思路
 * 下面的讨论中 x 代表 base，n 代表 exponent。
 *
 *
 * 因为 (x*x)的（n/2）次方可以通过递归求解，并且每次递归 n 都减小一半，因此整个算法的时间复杂度为 O(logN)。
 */
public class PowerOfNumericalValue {


    public static void main(String[] args) {

        System.out.println(power(12,6));
    }


    private static double power(double base,int exponent){

        if(0 == exponent){
            return 0;
        }
        if(1 == exponent){
            return base;
        }

        if(exponent % 2 == 0){
            return power(base*base,exponent/2);
        }else{
            return power(base * base * base ,exponent/2);
        }

    }

}
