package com.haothink;

/**
 * @author wanghao
 * @date 2019年07月06日 17:26
 * description: 二进制中 1 的个数
 *
 * 题目描述:
 * 输入一个整数，输出该数二进制表示中 1 的个数。
 *
 *
 * 把一个整数减去1，再和原整数做与运算，会把整数最右边一个1变成0.那么一个整数的二进制表示中有多少个1，就可以进行多次这样的操作。
 * n:  1000100
 * n-1:1000011
 * n&(n-1) = 1000000
 *
 */
public class NumberOfOneInBinary {


    public static void main(String[] args) {

        System.out.println(numberOfOne(153));
        System.out.println(numberOfOne2(153));
    }


    private static int numberOfOne(int n){

        if(0 == n){
            return 0;
        }
        int count = 0;
        while (n != 0){

            count++;
            n&=(n-1);
        }

        return count;
    }

    private static int numberOfOne2(int n){

        return Integer.bitCount(n);
    }
}
