package com.haothink.bjtu;

import java.util.Scanner;

/**
 * Created by wanghao on 2019-11-24
 题目描述
 楼梯有n阶，可以一步上一阶、两阶或三阶，问有多少种不同的走法
 由于答案很大，mod(1e9+7)输出

 输入数据
 一个正整数n，代表楼梯的阶数，n<=1000000

 输出数据
 **/

public class ZouTaijie {


    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        String initLine = scan.nextLine();
        int n = Integer.parseInt(initLine);

        if(n<=2){
            System.out.println(n);
        }
        int step1 = 1;
        int step2 = 2;
        int result = 0;
        for(int i=3;i<=n;i++){

            result = step1 + step2;
            step1 = step2;
            step2 = result;
        }

        System.out.println(result);

    }




}
