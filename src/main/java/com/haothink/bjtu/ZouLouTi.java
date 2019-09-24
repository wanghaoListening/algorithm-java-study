package com.haothink.bjtu;

import java.util.Scanner;

/**
 * @author wanghao
 * @date 2019年09月22日 21:38
 * description: 走台阶
 *
 * 题目描述
 * 楼梯有n阶，可以一步上一阶、两阶或三阶，问有多少种不同的走法
 * 由于答案很大，mod(1e9+7)输出
 *
 * 输入数据
 * 一个正整数n，代表楼梯的阶数，n<=1000000
 *
 * 输出数据
 * 方案数
 *
 * 样例输入
 * 3
 * 样例输出
 * 4
 */
public class ZouLouTi {

    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        int n = input.nextInt();

        System.out.println(jumpStep(n));

    }

    //一共有 f(n)=f(n-1)+f(n-2)+f(n-3)
    private static long jumpStep(int n){

        if(n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3){
            return 4;
        }
        long step1 = 1;
        long step2 = 2;
        long step3 = 4;
        long result = 0;
        for(long i=4;i<=n;i++){
            result = (step1 + step2 + step3)%1000000007;
            step1 = step2;
            step2 = step3;
            step3 = result;
        }
        return result;
    }

    public static long jumpFloor(int a) {
        if (a == 1) {
            return 1;
        } else if (a == 2) {
            return 2;
        } else if (a == 3){
            return 4;
        } else {
            return jumpFloor(a - 1) + jumpFloor(a - 2) + jumpFloor(a -3);
        }
    }

    private static long show(int a) {
        if (a == 1) {
            return 1;
        } else if (a == 2) {
            return 2;
        } else if (a == 3){
            return 4;
        } else {
            return show(a-1)*2;
        }
    }

    private static long countWays (int n) {
        if (n<0) {
            return 0;
        }
        if (n==0) {
            return 1;
        }
        else {
            return countWays(n-1)+countWays(n-2)+countWays(n-3);
        }
    }

}
